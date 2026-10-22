package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.pb.recognition.SpeechLang;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bBG\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$AudioViewHolder;", "languageList", "", "Lcom/ss/android/lark/pb/recognition/SpeechLang;", "defaultLangKeyList", "", "defaultLangNameList", "chosenLanguageKey", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "mItemClickListener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$OnLanguageItemClickListener;", "setOnLanguageItemClickListener", "", "l", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "AudioViewHolder", "OnLanguageItemClickListener", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioChooseLanguageDialogAdapter extends RecyclerView.Adapter<AudioViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpeechLang> f430812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f430813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f430814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f430815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f430816e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$AudioViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvLanguage", "Landroid/widget/TextView;", "getTvLanguage", "()Landroid/widget/TextView;", "ivChosen", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvChosen", "()Landroidx/appcompat/widget/AppCompatImageView;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f430817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f430818b;

        public AudioViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            super(r100);
            this.f430817a = (TextView) r100.findViewById(R.id.tv_language);
            this.f430818b = (AppCompatImageView) r100.findViewById(R.id.iv_chosen);
        }
    }

    public interface a {
        void j4(String r100, String r101, String r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<SpeechLang> r100 = this.f430812a;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L19;
        List<String> r103 = this.f430814c;
        if (r103 != null) goto L13;
    L15:
        r101 = false;
    L16:
        if (r101 == true) goto L18;
        return 0;
    L18:
        return this.f430814c.size();
    L13:
        if ((!r103.isEmpty()) != true) goto L15;
    L19:
        return this.f430812a.size();
    L5:
        if ((!r100.isEmpty()) != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AudioViewHolder r102 = (AudioViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<SpeechLang> r103 = this.f430812a;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        String r106 = ((SpeechLang) ListProtector.get(this.f430812a, r101)).mlangCode;
        String r107 = ((SpeechLang) ListProtector.get(this.f430812a, r101)).mlangName;
    L30:
        r102.f430817a.setText(r107);
        if (Intrinsics.areEqual(r106, this.f430815d) == false) goto L33;
        UIUtils.setViewVisibility(r102.f430818b, 0);
    L34:
        r102.itemView.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.utils.a(this, r101));
        return;
    L33:
        UIUtils.setViewVisibility(r102.f430818b, 8);
        goto L34
    L10:
        List<String> r108 = this.f430813b;
        if (r108 != null) goto L13;
    L15:
        boolean r109 = false;
    L16:
        if (r109 == false) goto L29;
        List<String> r110 = this.f430814c;
        if (r110 != null) goto L20;
    L22:
        r104 = false;
    L23:
        if (r104 == false) goto L29;
        if (r101 >= this.f430813b.size()) goto L29;
        if (r101 >= this.f430814c.size()) goto L29;
        r106 = (String) ListProtector.get(this.f430813b, r101);
        r107 = (String) ListProtector.get(this.f430814c, r101);
        goto L30
    L20:
        if ((!r110.isEmpty()) != true) goto L22;
    L29:
        r106 = "";
        r107 = "";
        goto L30
    L13:
        if ((!r108.isEmpty()) != true) goto L15;
        r109 = true;
        goto L16
    L5:
        if ((!r103.isEmpty()) != true) goto L7;
        r105 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_language_option, r100, false);
        Intrinsics.checkNotNull(r102);
        return new AudioViewHolder(r102);
    }

    public AudioChooseLanguageDialogAdapter(List<SpeechLang> r100, List<String> r101, List<String> r102, String r103) {
        this.f430812a = r100;
        this.f430813b = r101;
        this.f430814c = r102;
        this.f430815d = r103;
    }
}
