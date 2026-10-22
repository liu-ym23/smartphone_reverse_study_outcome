package com.bytedance.android.livesdk.mention;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.interactivity.api.expression.TextExtraStruct;
import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class MentionEditText extends EmojiEditView {
    public static final /* synthetic */ int m = 0;
    public d f;
    public int g;
    public boolean h;
    public em2.b i;
    public List<em2.b> j;
    public final List<TextWatcher> k;
    public View.OnKeyListener l;

    public static class MentionSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MentionSavedState> CREATOR = null;
        public String a;
        public int b;
        public List<TextExtraStruct> c;

        public class a implements Parcelable.Creator<MentionSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState createFromParcel(Parcel r2) {
                return new MentionSavedState(r2);
            L4:
                e = move-exception;
                e.printStackTrace();
                return null;
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState[] newArray(int r1) {
                return new MentionSavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public MentionSavedState(Parcel r2) {
            super(r2);
            this.a = r2.readString();
            this.b = r2.readInt();
            Bundle r3 = r2.readBundle(getClass().getClassLoader());
            if (r3 == null) goto L6;
            this.c = r3.getParcelableArrayList("text_extra_struct");
            return;
        }

        public MentionSavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            super.writeToParcel(r3, r4);
            r3.writeString(this.a);
            r3.writeInt(this.b);
            Bundle r5 = new Bundle();
            r5.putParcelableArrayList("text_extra_struct", (ArrayList) this.c);
            r3.writeBundle(r5);
        }
    }

    public class a extends InputConnectionWrapper {
        public final MentionEditText a;
        public final /* synthetic */ MentionEditText b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.bytedance.android.livesdk.mention.MentionEditText] */
        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r7) {
            ?? r0 = this.b;
            View.OnKeyListener r1 = r0.l;
            if (r1 == 0) goto L8;
            if (r1.onKey(r0, r7.getKeyCode(), r7) == false) goto L8;
            return true;
        L8:
            if (r7.getAction() != 0) goto L28;
            if (r7.getKeyCode() != 67) goto L28;
            int r2 = this.a.getSelectionStart();
            int r3 = this.a.getSelectionEnd();
            em2.b r4 = this.b.d(r2, r3);
            if (r4 != null) goto L15;
            this.b.h = false;
            return super.sendKeyEvent(r7);
        L15:
            MentionEditText r5 = this.b;
            if (r5.h == true) goto L25;
            int r6 = r4.a;
            if (r2 == r6) goto L25;
            r5.h = true;
            r5.i = r4;
            if (Build.VERSION.SDK_INT < 25) goto L23;
            setSelection(r6, r4.b);
        L24:
            return true;
        L23:
            setSelection(r4.b, r6);
        L25:
            r5.h = false;
            return super.sendKeyEvent(r7);
        L28:
            return super.sendKeyEvent(r7);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r1, int r2) {
            return super.commitText(r1, r2);
        L4:
            e = move-exception;
            e.printStackTrace();
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r14, int r15) {
            if (r14 != 1) goto L40;
            if (r15 != 0) goto L40;
            Editable r2 = this.b.getText();
            if (r2 != null) goto L8;
        L39:
            return false;
        L8:
            if (r2.length() <= 0) goto L39;
            EmojiEditView r3 = this.b;
            int r4 = MentionEditText.m;
            r3.getClass();
            int r5 = r2.length();
            int r16 = Math.max(r3.getSelectionStart() - r14, 0);
            int r17 = Math.min(r3.getSelectionEnd() + r15, r5);
            CharacterStyle[] r6 = (CharacterStyle[]) r2.getSpans(0, r5, CharacterStyle.class);
            int r7 = r6.length;
            int r8 = r16;
            int r9 = r17;
            int r10 = 0;
            boolean r11 = false;
            boolean r12 = false;
        L10:
            if (r10 >= r7) goto L24;
            CharacterStyle r13 = r6[r10];
            int r18 = r2.getSpanStart(r13);
            int r19 = r2.getSpanEnd(r13);
            if (r11 == true) goto L16;
            if (r18 > r16) goto L16;
            if (r19 <= r16) goto L16;
            r8 = r18;
            r11 = true;
        L16:
            if (r12 == true) goto L20;
            if (r18 >= r17) goto L20;
            if (r19 < r17) goto L20;
            r9 = r19;
            r12 = true;
        L20:
            if (r11 == false) goto L23;
            if (r12 == true) goto L24;
        L23:
            r10 = r10 + 1;
        L24:
            if (r8 <= r9) goto L26;
            int r110 = r9;
            r9 = r8;
            r8 = r110;
        L26:
            em2.b r111 = this.b.d(r8, r9);
            if (r111 == null) goto L38;
            MentionSpan[] r112 = (MentionSpan[]) r2.getSpans(r111.a, r111.b, MentionSpan.class);
            if (r112 == null) goto L38;
            if (r112.length <= 0) goto L38;
            if (sendKeyEvent(new KeyEvent(0, 67)) == true) goto L35;
            return false;
        L35:
            if (sendKeyEvent(new KeyEvent(1, 67)) == false) goto L54;
            return true;
        L54:
            return false;
        L38:
            r2.delete(r8, r9);
        L40:
            if (r14 >= 0) goto L42;
            int r113 = -r15;
            r15 = -r14;
            r14 = r113;
        L42:
            if (r14 < 0) goto L47;
            if (r15 < 0) goto L47;
            return super.deleteSurroundingText(r14, r15);
        L47:
            ALogger.e("LiveHackInputConnection", "Invalid length passed to deleteSurroundingText: before=" + r14 + ", after=" + r15);
            return false;
        }

        public a(MentionEditText r1, InputConnection r2, MentionEditText r3) {
            this.b = r1;
            super(r2, true);
            this.a = r3;
        }
    }

    public class b implements TextWatcher {
        public final /* synthetic */ MentionEditText a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(MentionEditText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return;
        L7:
            if ('@' != r1.toString().charAt(r2)) goto L12;
            MentionEditText r5 = this.a;
            int r6 = MentionEditText.m;
            r5.getClass();
            return;
        }
    }

    public interface c {
    }

    public static class d implements Runnable {
        public final WeakReference<MentionEditText> a;

        @Override // java.lang.Runnable
        public final void run() {
            EmojiEditView r0 = (MentionEditText) this.a.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setSelection(r0.getText().length());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(MentionEditText r2) {
            this.a = new WeakReference(r2);
        }
    }

    private void setClip(String r1) {
    }

    public void setOnMentionInputListener(c r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        this.j = new ArrayList(5);
        addTextChangedListener(new b(this));
        Context r0 = getContext();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.getResources().getConfiguration().getLayoutDirection() != 1) goto L7;
    L8:
        if (r2 == false) goto L11;
        setTextAlignment(5);
        setGravity(getGravity() | 8388611);
        return;
    L11:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public List<TextExtraStruct> getCompatTextExtraStructList() {
        return getTextExtraStructList();
    }

    public MentionSpan[] getMentionText() {
        final Editable r0 = getText();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L11;
        MentionSpan[] r1 = (MentionSpan[]) r0.getSpans(0, r0.length(), MentionSpan.class);
        Arrays.sort(r1, new em2.a(r0));
        return r1;
    L11:
        return null;
    }

    public int getMentionTextCount() {
        MentionSpan[] r0 = getMentionText();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        Editable r0 = getText();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L14;
        ArrayList<TextExtraStruct> r1 = new ArrayList();
        MentionSpan[] r2 = getMentionText();
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        MentionSpan r5 = r2[r4];
        r5.d.setStart(r0.getSpanStart(r5));
        r5.d.setEnd(r0.getSpanEnd(r5));
        r1.add(r5.d);
        r4 = r4 + 1;
        goto L8
    L10:
        return r1;
    L14:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Parcelable onSaveInstanceState() {
        MentionSavedState r1 = new MentionSavedState(super/*android.widget.EditText*/.onSaveInstanceState());
        r1.a = getText().toString();
        r1.b = Math.max(getSelectionEnd(), 0);
        r1.c = getCompatTextExtraStructList();
        return r1;
    }

    public int getMentionTextTypeface() {
        return this.g;
    }

    public MentionEditText(Context r1) {
        super(r1);
        this.k = new ArrayList();
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addTextChangedListener(TextWatcher r2) {
        super/*android.widget.EditText*/.addTextChangedListener(r2);
        List<TextWatcher> r0 = this.k;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.add(r2);
        return;
    L8:
        return;
    }

    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        InputConnection r3 = super/*androidx.appcompat.widget.AppCompatEditText*/.onCreateInputConnection(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new a(this, r3, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof MentionSavedState) == true) goto L6;
        super/*android.widget.EditText*/.onRestoreInstanceState(r3);
        return;
    L6:
        MentionSavedState r4 = (MentionSavedState) r3;
        super/*android.widget.EditText*/.onRestoreInstanceState(r4.getSuperState());
        setText(r4.a);
        int r0 = Math.min(r4.b, getText().length());
        if (r0 < 0) goto L9;
        setSelection(r0);
    L9:
        setTextExtraList(r4.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTextContextMenuItem(int r7) {
        if (r7 == 16908320) goto L7;
        if (r7 == 16908321) goto L7;
        String r2 = "";
    L11:
        boolean r3 = super.onTextContextMenuItem(r7);
        if (r7 == 16908320) goto L14;
        if (r7 == 16908321) goto L14;
    L15:
        return r3;
    L14:
        setClip(r2);
    L7:
        int r4 = getText().length();
        int r5 = 0;
        if (isFocused() == false) goto L10;
        int r6 = getSelectionStart();
        int r8 = getSelectionEnd();
        int r9 = Math.max(0, Math.min(r6, r8));
        r4 = Math.max(0, Math.max(r6, r8));
        r5 = r9;
    L10:
        r2 = getText().subSequence(r5, r4).toString();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeTextChangedListener(TextWatcher r2) {
        super/*android.widget.EditText*/.removeTextChangedListener(r2);
        List<TextWatcher> r0 = this.k;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.remove(r2);
        return;
    L8:
        return;
    }

    public void setMentionTextTypeface(int r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnKeyListener(View.OnKeyListener r1) {
        this.l = r1;
        super/*android.widget.EditText*/.setOnKeyListener(r1);
    }

    public void setTextExtraList(List<TextExtraStruct> r12) {
        this.h = false;
        List<em2.b> r0 = this.j;
        if (r0 == null) goto L5;
        ((ArrayList) r0).clear();
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.isEmpty() == true) goto L40;
        Editable r1 = getText();
        if (r1 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r1.toString()) == true) goto L41;
        int r2 = r1.length();
        Iterator<TextExtraStruct> r13 = r12.iterator();
    L16:
        if (r13.hasNext() == false) goto L42;
        TextExtraStruct r3 = r13.next();
        if (r3.getStart() > r2) goto L16;
        if (r3.getEnd() > r2) goto L16;
        if (r3.getStart() > r3.getEnd()) goto L16;
        if (r3.getStart() < 0) goto L16;
        r1.setSpan(new MentionSpan(new com.bytedance.android.livesdk.interactivity.api.expression.d(r3.getColor(), r1.subSequence(r3.getStart(), r3.getEnd()).toString(), r3.getUserId(), r3.getWebcastUid(), r3.getUser(), false)), r3.getStart(), r3.getEnd(), 33);
        em2.b r4 = new em2.b(r3.getStart(), r3.getEnd());
        ((ArrayList) this.j).add(r4);
        goto L16
    L42:
        return;
    L41:
        return;
    }

    public void setTextWithoutAutoSelectLast(String r2) {
        super.setText(r2, TextView.BufferType.EDITABLE);     // Catch: Exception -> L4
        return;
    }

    public MentionEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.k = new ArrayList();
        e();
    }

    public final em2.b d(int r5, int r6) {
        List<em2.b> r0 = this.j;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterator r1 = ((ArrayList) r0).iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        em2.b r2 = (em2.b) r1.next();
        if (r2.a <= r5) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L7;
        return r2;
    L11:
        if (r2.b < r6) goto L13;
        r3 = true;
        goto L14
    L16:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSelectionChanged(int r8, int r9) {
        super/*android.widget.EditText*/.onSelectionChanged(r8, r9);
        em2.b r0 = this.i;
        if (r0 == null) goto L15;
        int r3 = r0.a;
        if (r3 == r8) goto L7;
    L8:
        if (r3 == r9) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
        return;
    L10:
        if (r0.b != r8) goto L12;
    L11:
        r1 = true;
        goto L13
    L7:
        if (r0.b == r9) goto L11;
    L15:
        em2.b r2 = d(r8, r9);
        if (r2 != null) goto L18;
    L20:
        List<em2.b> r4 = this.j;
        em2.b r5 = null;
        if (r4 == null) goto L37;
        Iterator r6 = ((ArrayList) r4).iterator();
    L25:
        if (r6.hasNext() == false) goto L37;
        em2.b r7 = (em2.b) r6.next();
        int r10 = r7.a;
        if (r8 > r10) goto L29;
    L30:
        if (r9 > r10) goto L32;
    L34:
        boolean r11 = false;
    L35:
        if (r11 == false) goto L25;
        r5 = r7;
        goto L37
    L32:
        if (r9 >= r7.b) goto L34;
    L33:
        r11 = true;
        goto L35
    L29:
        if (r8 < r7.b) goto L33;
    L37:
        if (r5 != null) goto L54;
        return;
    L54:
        if (r8 != r9) goto L44;
        int r12 = r5.a;     // Catch: IndexOutOfBoundsException -> L51
        int r13 = r5.b;     // Catch: IndexOutOfBoundsException -> L51
        if (((r8 - r12) - (r13 - r8)) < 0) goto L43;
        r12 = r13;
    L43:
        setSelection(r12);     // Catch: IndexOutOfBoundsException -> L51
        return;
    L44:
        int r14 = r5.b;     // Catch: IndexOutOfBoundsException -> L51
        if (r9 >= r14) goto L47;
        setSelection(r8, r14);     // Catch: IndexOutOfBoundsException -> L51
    L47:
        int r15 = r5.a;     // Catch: IndexOutOfBoundsException -> L51
        if (r8 <= r15) goto L61;
        setSelection(r15, r9);     // Catch: IndexOutOfBoundsException -> L51
        return;
    L61:
        return;
    L51:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        if (r2.b != r9) goto L20;
        this.h = false;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);     // Catch: Exception -> L4
    L6:
        if (this.f != null) goto L9;
        this.f = new d(this);
    L9:
        if (getText().length() <= 0) goto L14;
        post(this.f);
        return;
    }

    public MentionEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = new ArrayList();
        e();
    }

    public final void onTextChanged(CharSequence r5, int r6, int r7, int r8) {
        int r9 = 0;
        this.h = false;
        List<em2.b> r10 = this.j;
        if (r10 == null) goto L5;
        ((ArrayList) r10).clear();
    L5:
        Editable r11 = getText();
        if (r11 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11.toString()) == true) goto L21;
        MentionSpan[] r12 = getMentionText();
        int r13 = r12.length;
    L11:
        if (r9 >= r13) goto L22;
        MentionSpan r0 = r12[r9];
        int r2 = r11.getSpanStart(r0);
        int r3 = r11.getSpanEnd(r0);
        em2.b r1 = new em2.b(r2, r3);
        if (TextUtils.equals(r11.subSequence(r2, r3).toString(), r0.c) == true) goto L15;
        r11.removeSpan(r0);
    L16:
        r9 = r9 + 1;
        goto L11
    L15:
        ((ArrayList) this.j).add(r1);
        goto L16
    L22:
        return;
    }
}
