package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.dux.api.IDuxEmojiService;
import com.bytedance.dux.utils.EmojiEditTextHelper;
import com.bytedance.dux.utils.EmojiEditTextHelper$textWatcher$2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class DmtEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EmojiEditTextHelper f248417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<View.OnFocusChangeListener> f248418b;

    public interface a {
    }

    public void setTextContextMenuListener(a r100) {
    }

    private EmojiEditTextHelper getEmojiViewHelper() {
        if (this.f248417a != null) goto L6;
        this.f248417a = new EmojiEditTextHelper(this);
    L6:
        return this.f248417a;
    }

    public DmtEditText(Context r100) {
        this(r100, null);
    }

    public final void c(AttributeSet r100) {
        com.bytedance.dux.text.a.b().a(this, r100);
        EmojiEditTextHelper r101 = getEmojiViewHelper();
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        if (((Boolean) r101.f205846e.getValue()).booleanValue() == false) goto L17;
        r101.f205842a.addTextChangedListener((EmojiEditTextHelper$textWatcher$2.a) r101.f205847f.getValue());
        IDuxEmojiService r102 = r101.a();
        if (r102 == null) goto L14;
        Editable.Factory r103 = r102.getEditableFactory();
        if (r103 == null) goto L15;
        r101.f205842a.setEditableFactory(r103);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent r100) {
        return super.onDragEvent(r100);
    L4:
        e = move-exception;
        throw e;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        return super.onTextContextMenuItem(r100);
    }

    public void setEnableParseEmoji(boolean r100) {
        EmojiEditTextHelper r101 = getEmojiViewHelper();
        if (r101.f205843b == r100) goto L32;
        com.bytedance.dux.utils.b r102 = r101.f205844c;
        if (r102 == null) goto L9;
        IDuxEmojiService r103 = r101.a();
        if (r103 == null) goto L9;
        r103.removeSystemEmojiLoadCallback(r102);
    L9:
        r101.f205843b = r100;
        if (r100 == false) goto L33;
        IDuxEmojiService r104 = r101.a();
        if (r104 == null) goto L16;
        boolean r105 = true;
        if (r104.systemEmojiLoaded() != true) goto L16;
    L17:
        if (r105 == true) goto L19;
        return;
    L19:
        if (r101.f205842a.isAttachedToWindow() == false) goto L35;
        Editable r106 = r101.f205842a.getEditableText();
        int r107 = Selection.getSelectionStart(r106);
        int r108 = Selection.getSelectionEnd(r106);
        IDuxEmojiService r109 = r101.a();
        if (r109 == null) goto L23;
        r109.process(r101.f205842a, r106);
    L23:
        int r110 = com.bytedance.dux.utils.b.f205858b;
        Intrinsics.checkNotNullParameter(r106, "spannable");
        if (r107 < 0) goto L27;
        if (r108 < 0) goto L27;
        Selection.setSelection(r106, r107, r108);
        return;
    L27:
        if (r107 < 0) goto L29;
        Selection.setSelection(r106, r107);
        return;
    L29:
        if (r108 < 0) goto L38;
        Selection.setSelection(r106, r108);
        return;
    L38:
        return;
    L35:
        return;
    L16:
        r105 = false;
        goto L17
    L33:
        return;
    }

    public void setFontType(String r100) {
        com.bytedance.dux.text.a r101 = com.bytedance.dux.text.a.b();
        monitor-enter(r101);
        monitor-exit(r101);
    }

    public DmtEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248418b = new ArrayList();
        c(r101);
    }

    public DmtEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248418b = new ArrayList();
        c(r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
        Iterator<View.OnFocusChangeListener> r103 = this.f248418b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onFocusChange(this, r100);
        goto L4
    }
}
