package com.larus.voicecall.impl.subtitle;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.databinding.LarusSubtitleHolderSingleImageBinding;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.u2;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleSingleImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemViewBinding", "Lcom/larus/voicecall/impl/databinding/LarusSubtitleHolderSingleImageBinding;", "uploadListener", "Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;", "ability", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusSubtitleHolderSingleImageBinding;Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;)V", "data", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "value", "", "isUploadImageErr", "()Z", "setUploadImageErr", "(Z)V", "bindData", "", "mobHolderShow", "onViewDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleSingleImageHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f378834f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusSubtitleHolderSingleImageBinding f378835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f378836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f378837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f378838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f378839e;

    public static final class a {
    }

    static {
        f378834f = new LinkedHashSet();
    }

    public final void T3() {
        c r100 = this.f378838d;
        String r101 = null;
        if (r100 == null) goto L7;
        x3a.a r102 = r100.f378862i;
        if (r102 == null) goto L7;
        String r103 = r102.f562408e;
    L8:
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        Set<String> r105 = f378834f;
        if (r105.contains(r103) == false) goto L14;
        return;
    L14:
        if (StringsKt.isBlank(r103) == true) goto L42;
        r105.add(r103);
        String r106 = this.f378837c.L();
        JSONObject r107 = new JSONObject();
        r107.put("if_call", 1);
        RealtimeCallParam r108 = this.f378837c.d();
        if (r108 == null) goto L19;
        String r109 = r108.f288745e;
    L20:
        r107.put("call_id", r109);
        RealtimeCallParam r110 = this.f378837c.d();
        if (r110 == null) goto L23;
        String r111 = r110.f288743d;
    L24:
        if (r111 == null) goto L27;
        r104 = r111;
    L27:
        r107.put("room_id", r104);
        RealtimeCallParam r112 = this.f378837c.d();
        if (r112 == null) goto L32;
        RealtimeCallParam.k r113 = r112.f288756p;
        if (r113 == null) goto L32;
        r101 = r113.f288861i;
    L32:
        r107.put("call_enter_method", r101);
        r107.put("is_subtitles_mode", 1);
        r107.put("conversation_id", this.f378837c.K());
        com.larus.voicecall.impl.scene.m r114 = this.f378837c.a();
        if (r114 == null) goto L38;
        SceneModel r115 = r114.f378735a;
        if (r115 == null) goto L38;
        String r116 = r115.getKey();
        if (r116 == null) goto L38;
    L39:
        r107.put("call_scene", r116);
        u2.c(r106, null, null, null, null, null, null, null, "user", null, null, null, null, r107, null, 114430);
        return;
    L38:
        r116 = "other";
        goto L39
    L23:
        r111 = null;
        goto L24
    L19:
        r109 = null;
        goto L20
    L42:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void U3(boolean r100) {
        if (r100 == false) goto L4;
        com.larus.utils.e1.o(this.f378835a.f378311e);
        com.larus.utils.e1.o(this.f378835a.f378309c);
        com.larus.utils.e1.x(this.f378835a.f378310d);
    L5:
        this.f378839e = r100;
        return;
    L4:
        com.larus.utils.e1.o(this.f378835a.f378310d);
        goto L5
    }

    public SubtitleSingleImageHolder(LarusSubtitleHolderSingleImageBinding r100, h r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "itemViewBinding");
        Intrinsics.checkNotNullParameter(r101, "uploadListener");
        Intrinsics.checkNotNullParameter(r102, "ability");
        super(r100.f378307a);
        this.f378835a = r100;
        this.f378836b = r101;
        this.f378837c = r102;
        com.larus.utils.e1.d(r100.f378310d, new r1(this));
        com.larus.utils.e1.d(r100.f378308b, new s1(this));
    }
}
