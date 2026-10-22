package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusViewChatFileSelectorBinding;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import com.larus.platform.api.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z19.c;
import z19.d;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/ChatFileSelectorView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewChatFileSelectorBinding;", "selectedList", "", "Lcom/larus/platform/api/FlowSelectedFileItem;", "setSelectedList", "", "setOnSelectedTextClickListener", "listener", "Landroid/view/View$OnClickListener;", "initConfig", "config", "Lcom/larus/common_ui/widget/ChatFileSelectorView$SelectorConfig;", "SelectorConfig", "ISelectorCallback", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectorView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f328392c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusViewChatFileSelectorBinding f328393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<u> f328394b;

    public interface a {
        void a();

        void b(String r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f328395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<u> f328396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f328397c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f328395a, r101.f328395a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f328396b, r101.f328396b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f328397c, r101.f328397c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f328395a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f328396b.hashCode()) * 31;
            a r104 = this.f328397c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectorConfig(tag=" + this.f328395a + ", selectedList=" + this.f328396b + ", selectorCallback=" + this.f328397c + ')';
        }

        public b() {
            this(null, CollectionsKt.emptyList(), null);
        }

        public b(String r100, List<u> r101, a r102) {
            Intrinsics.checkNotNullParameter(r101, "selectedList");
            this.f328395a = r100;
            this.f328396b = r101;
            this.f328397c = r102;
        }
    }

    public ChatFileSelectorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatFileSelectorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        setSelectedList(r100.f328396b);
        setOnSelectedTextClickListener(new c(r100));
        this.f328393a.f326804c.setOnClickListener(new d(r100));
    }

    public final void setOnSelectedTextClickListener(View.OnClickListener r100) {
        this.f328393a.f326806e.setOnClickListener(r100);
    }

    public final void setSelectedList(List<u> r110) {
        Intrinsics.checkNotNullParameter(r110, "selectedList");
        this.f328394b = r110;
        int r111 = r110.size();
        if (r111 > 0) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        this.f328393a.f326803b.setText(getContext().getResources().getQuantityString(R.plurals.larus_chat_addFile_selectedFiles_number_new, r111, new Object[]{String.valueOf(r111)}));
        AppCompatTextView r100 = this.f328393a.f326805d;
        Context r101 = getContext();
        int r102 = com.larus.common_ui.a.f326853a;
        r100.setText(StringsKt.replace$default(r101.getString(R.string.larus_chat_upload_confirm_files_button_cn), "%s", String.valueOf(r111), false, 4, null));
    }

    public ChatFileSelectorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_view_chat_file_selector, this, false);
        addView(r103);
        int r104 = R.id.chat_selected_count;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.chat_selected_count);
        if (r105 == null) goto L13;
        r104 = R.id.chat_selected_next_btn;
        RoundFrameLayout r106 = (RoundFrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_selected_next_btn);
        if (r106 == null) goto L13;
        r104 = R.id.chat_selected_next_text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.chat_selected_next_text);
        if (r107 == null) goto L13;
        r104 = R.id.chat_selected_tip_container;
        LinearLayout r108 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.chat_selected_tip_container);
        if (r108 == null) goto L13;
        this.f328393a = new LarusViewChatFileSelectorBinding((LinearLayout) r103, r105, r106, r107, r108);
        this.f328394b = CollectionsKt.emptyList();
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ ChatFileSelectorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
