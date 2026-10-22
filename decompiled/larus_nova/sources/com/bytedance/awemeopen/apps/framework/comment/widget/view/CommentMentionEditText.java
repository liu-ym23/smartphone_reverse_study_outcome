package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003 !\"B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$b;", "onPasteListener", "", "setOnPasteListener", "", "imeOptions", "setImeOptions", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$a;", "onClipPasteListener", "setOnClipPasteListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$c;", "onSelectionChangedListener", "setOnSelectionChangedListener", "", "Lcom/bytedance/awemeopen/apps/framework/comment/write/model/TextExtraStruct;", "structList", "setTextExtraList", "Ljava/util/ArrayList;", "getTextExtraStructList", "()Ljava/util/ArrayList;", "textExtraStructList", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMentionEditText extends MentionEditText {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f194314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f194315m;

    public interface a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public final boolean g(int r100) {
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        if (r100 == 6) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        return e(new int[]{0, 6});
    }

    public final void setOnClipPasteListener(a r100) {
    }

    public CommentMentionEditText(Context r100) {
        new LinkedHashMap();
        super(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908322) goto L8;
        b r101 = this.f194314l;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        return super.onTextContextMenuItem(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onTouchEvent(r100);
    L8:
        return false;
    }

    @Override // android.widget.TextView
    public void setImeOptions(int r100) {
        super.setImeOptions(r100 | 33554432);
    }

    public final void setOnPasteListener(b r100) {
        this.f194314l = r100;
    }

    public final void setOnSelectionChangedListener(c r100) {
        this.f194315m = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public void setTextExtraList(List<? extends TextExtraStruct> r100) {
        super.setTextExtraList(r100);
        if (com.bytedance.awemeopen.infra.util.d.a(r100) == false) goto L24;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r101 = this.f194336h;
        if (r101 == null) goto L7;
        r101.clear();
    L7:
        Editable r102 = getText();
        MentionEditText.MentionSpan[] r103 = getMentionText();
        if (r102 == null) goto L35;
        if (r103 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r102.toString()) == true) goto L37;
        Iterator r104 = ArrayIteratorKt.iterator(r103);
    L15:
        if (r104.hasNext() == false) goto L38;
        MentionEditText.MentionSpan r105 = (MentionEditText.MentionSpan) r104.next();
        int r106 = r102.getSpanStart(r105);
        int r107 = r102.getSpanEnd(r105);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r108 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r106, r107);
        if (TextUtils.equals(r102.subSequence(r106, r107).toString(), r105.f194343b) == false) goto L18;
        if (g(r105.getType()) == false) goto L15;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r109 = this.f194336h;
        if (r109 == null) goto L15;
        r109.add(r108);
        goto L15
    L18:
        r102.removeSpan(r105);
        goto L15
    L38:
        return;
    L37:
        return;
    L35:
        return;
    }

    public CommentMentionEditText(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        super(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText, android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        c r102 = this.f194315m;
        if (r102 == null) goto L6;
        r102.a();
        return;
    }

    public CommentMentionEditText(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
    }
}
