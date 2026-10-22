package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003 !\"B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$b;", "onPasteListener", "", "setOnPasteListener", "", "imeOptions", "setImeOptions", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$a;", "onClipPasteListener", "setOnClipPasteListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentMentionEditText$c;", "onSelectionChangedListener", "setOnSelectionChangedListener", "", "Lcom/bytedance/awemeopen/apps/framework/comment/write/model/TextExtraStruct;", "structList", "setTextExtraList", "Ljava/util/ArrayList;", "getTextExtraStructList", "()Ljava/util/ArrayList;", "textExtraStructList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMentionEditText extends MentionEditText {
    public b l;
    public c m;

    public interface a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public final boolean g(int r4) {
        if (r4 != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return true;
    L8:
        if (r4 == 6) goto L13;
        return false;
    L13:
        return true;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        return e(new int[]{0, 6});
    }

    public final void setOnClipPasteListener(a r1) {
    }

    public CommentMentionEditText(Context r2) {
        new LinkedHashMap();
        super(r2);
    }

    public final boolean onTextContextMenuItem(int r2) {
        if (r2 != 16908322) goto L8;
        b r0 = this.l;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        return super.onTextContextMenuItem(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super/*android.widget.EditText*/.onTouchEvent(r2);
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImeOptions(int r2) {
        super/*android.widget.EditText*/.setImeOptions(r2 | 33554432);
    }

    public final void setOnPasteListener(b r1) {
        this.l = r1;
    }

    public final void setOnSelectionChangedListener(c r1) {
        this.m = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public void setTextExtraList(List<? extends TextExtraStruct> r6) {
        super.setTextExtraList(r6);
        if (com.bytedance.awemeopen.infra.util.d.a(r6) == false) goto L24;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r7 = this.h;
        if (r7 == null) goto L7;
        r7.clear();
    L7:
        Editable r8 = getText();
        MentionEditText.MentionSpan[] r0 = getMentionText();
        if (r8 == null) goto L35;
        if (r0 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r8.toString()) == true) goto L37;
        Iterator r1 = ArrayIteratorKt.iterator(r0);
    L15:
        if (r1.hasNext() == false) goto L38;
        MentionEditText.MentionSpan r2 = (MentionEditText.MentionSpan) r1.next();
        int r3 = r8.getSpanStart(r2);
        int r4 = r8.getSpanEnd(r2);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r5 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r3, r4);
        if (TextUtils.equals(r8.subSequence(r3, r4).toString(), r2.b) == false) goto L18;
        if (g(r2.getType()) == false) goto L15;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r9 = this.h;
        if (r9 == null) goto L15;
        r9.add(r5);
        goto L15
    L18:
        r8.removeSpan(r2);
        goto L15
    L38:
        return;
    L37:
        return;
    L35:
        return;
    }

    public CommentMentionEditText(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        super(r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText
    public final void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        c r3 = this.m;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    public CommentMentionEditText(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        super(r2, r3, r4);
    }
}
