package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.awemeopen.apps.framework.comment.widget.DmtEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0006\u000bYZ\u0013\u001a\u001fB\u0013\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SB\u001d\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bR\u0010VB%\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\u0012¢\u0006\u0004\bR\u0010XJ\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010B\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001e\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bG\u0010?R\u0019\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010C8F¢\u0006\u0006\u001a\u0004\bI\u0010ER\u0019\u0010O\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010K8F¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006["}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/DmtEditText;", "", "Lcom/bytedance/awemeopen/apps/framework/comment/write/model/TextExtraStruct;", "structList", "", "setTextExtraList", "Landroid/view/View$OnKeyListener;", "l", "setOnKeyListener", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "getAction", "()Ljava/lang/Runnable;", "setAction", "(Ljava/lang/Runnable;)V", "action", "", "b", "I", "getMentionTextColor", "()I", "setMentionTextColor", "(I)V", "mentionTextColor", "c", "getMStarAtlasMentionTextColor", "setMStarAtlasMentionTextColor", "mStarAtlasMentionTextColor", "", "d", "Z", "getHandlingMentionHint", "()Z", "setHandlingMentionHint", "(Z)V", "handlingMentionHint", "e", "getMIsSelected", "setMIsSelected", "mIsSelected", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "f", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "getLastSelectedRange", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "setLastSelectedRange", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;)V", "lastSelectedRange", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", "g", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", "getOnMentionInputListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", "setOnMentionInputListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;)V", "onMentionInputListener", "", "Landroid/text/TextWatcher;", "i", "Ljava/util/List;", "getTextWatcherList", "()Ljava/util/List;", "setTextWatcherList", "(Ljava/util/List;)V", "textWatcherList", "Ljava/util/ArrayList;", "getTextExtraStructList", "()Ljava/util/ArrayList;", "textExtraStructList", "getCompatTextExtraStructList", "compatTextExtraStructList", "getStarAtlasExtraList", "starAtlasExtraList", "", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "getMentionText", "()[Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "mentionText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MentionSavedState", "MentionSpan", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class MentionEditText extends DmtEditText {
    public static final /* synthetic */ int k = 0;
    public Runnable a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public com.bytedance.awemeopen.apps.framework.comment.widget.view.c f;
    public c g;
    public List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> h;
    public List<TextWatcher> i;
    public View.OnKeyListener j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSavedState;", "Landroid/view/View$BaseSavedState;", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class MentionSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MentionSavedState> CREATOR = null;
        public String a;
        public int b;
        public List<? extends TextExtraStruct> c;

        public static final class a implements Parcelable.Creator<MentionSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "in");
                return new MentionSavedState(r2);
            L5:
                return null;
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState[] newArray(int r1) {
                return new MentionSavedState[r1];
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public MentionSavedState(Parcel r2) {
            super(r2);
            this.a = r2.readString();
            this.b = r2.readInt();
            Bundle r3 = r2.readBundle(MentionSavedState.class.getClassLoader());
            if (r3 == null) goto L6;
            this.c = r3.getParcelableArrayList("text_extra_struct");
            return;
        }

        public MentionSavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "out");
            super.writeToParcel(r3, r4);
            r3.writeString(this.a);
            r3.writeInt(this.b);
            Bundle r5 = new Bundle();
            r5.putParcelableArrayList("text_extra_struct", (ArrayList) this.c);
            r3.writeBundle(r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "Landroid/text/style/ForegroundColorSpan;", "", "c", "I", "getType", "()I", "setType", "(I)V", "type", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class MentionSpan extends ForegroundColorSpan {
        public final String a;
        public final String b;
        public final int c;
        public final TextExtraStruct d;
        public String e;
        public int f;
        public String g;

        public static final class a {
        }

        static {
        }

        @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L6;
            if (r0 == null) goto L6;
            int r2 = r0.hashCode();
        L7:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            if (r4 == null) goto L11;
            int r5 = r4.hashCode();
        L12:
            int r6 = (((r3 + r5) * 31) + this.c) * 31;
            TextExtraStruct r7 = this.d;
            if (r7 == null) goto L16;
            if (r7 == null) goto L16;
            int r8 = r7.hashCode();
        L17:
            int r9 = (r6 + r8) * 31;
            String r10 = this.e;
            if (r10 == null) goto L21;
            if (r10 == null) goto L21;
            int r11 = r10.hashCode();
        L22:
            int r12 = (((r9 + r11) * 31) + this.f) * 31;
            String r13 = this.g;
            if (r13 == null) goto L27;
            if (r13 == null) goto L27;
            r1 = r13.hashCode();
        L27:
            return r12 + r1;
        L21:
            r11 = 0;
        L16:
            r8 = 0;
        L11:
            r5 = 0;
        L6:
            r2 = 0;
            goto L7
        }

        public final int getType() {
            return this.c;
        }

        public MentionSpan(com.bytedance.awemeopen.apps.framework.comment.widget.view.b r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            super(r3.a);
            this.e = "";
            this.g = "";
            this.a = r3.c;
            this.b = r3.b;
            this.c = r3.getType();
            String r0 = r3.f;
            this.g = r0;
            TextExtraStruct r1 = this.d;
            if (r1 == null) goto L6;
            r1.setSecUid(r0);
        L6:
            TextExtraStruct r2 = r3.h;
            if (r2 != null) goto L9;
            TextExtraStruct r4 = new TextExtraStruct();
            this.d = r4;
            r4.setUserId(r3.c);
            r4.setType(r3.getType());
            r4.setAtUserType(r3.e);
            r4.setSecUid(r3.c);
            r4.setUserUserFollowStatus(r3.g);
            return;
        L9:
            this.d = r2;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L67:
            return false;
        L8:
            if (Intrinsics.areEqual(MentionSpan.class, r5.getClass()) == false) goto L67;
            MentionSpan r6 = (MentionSpan) r5;
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            if (this.f == r6.f) goto L16;
            return false;
        L16:
            String r2 = this.a;
            if (r2 == null) goto L22;
            if (Intrinsics.areEqual(r2, r6.a) == false) goto L23;
        L24:
            boolean r3 = false;
        L25:
            if (r3 == false) goto L27;
            return false;
        L27:
            String r4 = this.b;
            if (r4 == null) goto L33;
            if (Intrinsics.areEqual(r4, r6.b) == false) goto L34;
        L35:
            boolean r7 = false;
        L36:
            if (r7 == false) goto L38;
            return false;
        L38:
            TextExtraStruct r8 = this.d;
            if (r8 == null) goto L44;
            if (Intrinsics.areEqual(r8, r6.d) == false) goto L45;
        L46:
            boolean r9 = false;
        L47:
            if (r9 == false) goto L49;
            return false;
        L49:
            String r10 = this.e;
            if (r10 == null) goto L55;
            if (Intrinsics.areEqual(r10, r6.e) == false) goto L56;
        L57:
            boolean r11 = false;
        L58:
            if (r11 == false) goto L60;
            return false;
        L60:
            String r12 = this.g;
            String r13 = r6.g;
            if (r12 != null) goto L68;
            if (r13 == null) goto L69;
            return false;
        L69:
            return true;
        L68:
            return Intrinsics.areEqual(r12, r13);
        L56:
            r11 = true;
            goto L58
        L55:
            if (r6.e == null) goto L57;
        L45:
            r9 = true;
            goto L47
        L44:
            if (r6.d == null) goto L46;
        L34:
            r7 = true;
            goto L36
        L33:
            if (r6.b == null) goto L35;
        L23:
            r3 = true;
            goto L25
        L22:
            if (r6.a == null) goto L24;
            goto L23
        }

        @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "dest");
            r2.writeString(this.a);
            r2.writeString(this.b);
            r2.writeInt(this.c);
            r2.writeParcelable(this.d, r3);
            r2.writeString(this.g);
        }
    }

    public final class a extends InputConnectionWrapper {
        public final MentionEditText a;
        public final /* synthetic */ MentionEditText b;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            View.OnKeyListener r0 = this.b.j;
            if (r0 == null) goto L7;
            Intrinsics.checkNotNull(r0);
            return r0.onKey(this.b, r5.getKeyCode(), r5);
        L7:
            if (r5.getAction() != 0) goto L27;
            if (r5.getKeyCode() != 67) goto L27;
            int r1 = this.a.getSelectionStart();
            int r2 = this.a.getSelectionEnd();
            com.bytedance.awemeopen.apps.framework.comment.widget.view.c r3 = this.b.d(r1, r2);
            if (r3 != null) goto L15;
            this.b.setMIsSelected(false);
            return super.sendKeyEvent(r5);
        L15:
            if (this.b.getMIsSelected() == false) goto L17;
        L24:
            this.b.setMIsSelected(false);
            return super.sendKeyEvent(r5);
        L17:
            if (r1 == r3.a) goto L24;
            this.b.setMIsSelected(true);
            this.b.setLastSelectedRange(r3);
            if (Build.VERSION.SDK_INT < 25) goto L22;
            setSelection(r3.a, r3.b);
        L23:
            return true;
        L22:
            setSelection(r3.b, r3.a);
        L27:
            return super.sendKeyEvent(r5);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r2, int r3) {
            if (r2 != null) goto L8;
            return true;
        L8:
            return super.commitText(r2, r3);
        L10:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r14, int r15) {
            if (r14 != 1) goto L46;
            if (r15 != 0) goto L46;
            Editable r1 = this.b.getText();
            if (r1 != null) goto L8;
        L45:
            return false;
        L8:
            if (r1.length() <= 0) goto L45;
            AppCompatEditText r3 = this.b;
            int r4 = MentionEditText.k;
            r3.getClass();
            int r5 = r1.length();
            int r16 = Math.max(r3.getSelectionStart() - r14, 0);
            int r17 = Math.min(r3.getSelectionEnd() + r15, r5);
            CharacterStyle[] r6 = (CharacterStyle[]) r1.getSpans(0, r5, CharacterStyle.class);
            int r7 = r6.length;
            int r8 = r16;
            int r9 = r17;
            int r10 = 0;
            boolean r11 = false;
            boolean r12 = false;
        L10:
            if (r10 >= r7) goto L29;
            CharacterStyle r13 = r6[r10];
            if ((r13 instanceof MentionSpan) == true) goto L14;
        L16:
            int r18 = r1.getSpanStart(r13);
            int r19 = r1.getSpanEnd(r13);
            if (r11 == true) goto L21;
            if (r18 > r16) goto L21;
            if (r19 <= r16) goto L21;
            r8 = r18;
            r11 = true;
        L21:
            if (r12 == true) goto L25;
            if (r18 >= r17) goto L25;
            if (r19 < r17) goto L25;
            r9 = r19;
            r12 = true;
        L25:
            if (r11 == false) goto L28;
            if (r12 == true) goto L29;
        L28:
            r10 = r10 + 1;
            goto L10
        L14:
            if (((MentionSpan) r13).getType() != 1) goto L16;
        L29:
            if (r8 <= r9) goto L31;
            int r110 = r9;
            r9 = r8;
            r8 = r110;
        L31:
            com.bytedance.awemeopen.apps.framework.comment.widget.view.c r111 = this.b.d(r8, r9);
            if (r111 == null) goto L44;
            MentionSpan[] r112 = (MentionSpan[]) r1.getSpans(r111.a, r111.b, MentionSpan.class);
            if (r112 == null) goto L44;
            if (r112.length <= 0) goto L44;
            if (sendKeyEvent(new KeyEvent(0, 67)) == true) goto L40;
        L42:
            return false;
        L40:
            if (sendKeyEvent(new KeyEvent(1, 67)) == false) goto L42;
            return true;
        L44:
            r1.delete(r8, r9);
        L46:
            if (r14 >= 0) goto L49;
            int r113 = -r15;
            r15 = -r14;
            r14 = r113;
        L49:
            return super.deleteSurroundingText(r14, r15);
        }

        public a(MentionEditText r2, InputConnection r3, MentionEditText r4) {
            Intrinsics.checkNotNullParameter(r4, "editText");
            this.b = r2;
            super(r3, true);
            this.a = r4;
        }
    }

    public final class b implements TextWatcher {
        public final /* synthetic */ MentionEditText a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            Intrinsics.checkNotNullParameter(r2, "editable");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "charSequence");
        }

        public b(MentionEditText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "charSequence");
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return;
        L7:
            if ('@' == r1.toString().charAt(r2)) goto L9;
            return;
        L9:
            if (this.a.getOnMentionInputListener() == null) goto L15;
            c r5 = this.a.getOnMentionInputListener();
            Intrinsics.checkNotNull(r5);
            r5.a();
            return;
        }
    }

    public interface c {
        void a();
    }

    public static final class d implements Runnable {
        public final WeakReference<MentionEditText> a;

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatEditText r0 = (MentionEditText) this.a.get();     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            Editable r1 = r0.getText();     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            int r2 = r1.length();     // Catch: Throwable -> L10
        L8:
            r0.setSelection(r2);     // Catch: Throwable -> L10
            return;
        L7:
            r2 = 0;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(MentionEditText r2) {
            Intrinsics.checkNotNullParameter(r2, "editText");
            this.a = new WeakReference(r2);
        }
    }

    public boolean g(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        return e(new int[]{0});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        this.h = new ArrayList(5);
        this.b = -65536;
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

    public final List<TextExtraStruct> getCompatTextExtraStructList() {
        return getTextExtraStructList();
    }

    public final MentionSpan[] getMentionText() {
        final Editable r0 = getText();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L11;
        MentionSpan[] r1 = (MentionSpan[]) r0.getSpans(0, r0.length(), MentionSpan.class);
        final Function2<MentionSpan, MentionSpan, Integer> r2 = new MentionEditText$mentionText$1(r0);
        Arrays.sort(r1, new com.bytedance.awemeopen.apps.framework.comment.widget.view.a(r2));
        return r1;
    L11:
        return null;
    }

    public final ArrayList<TextExtraStruct> getStarAtlasExtraList() {
        Editable r0 = getText();
        MentionSpan[] r1 = getMentionText();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L36;
        if (r1 == null) goto L37;
        ArrayList<TextExtraStruct> r2 = new ArrayList();
        Iterator r3 = ArrayIteratorKt.iterator(r1);
    L10:
        if (r3.hasNext() == false) goto L28;
        MentionSpan r4 = (MentionSpan) r3.next();
        TextExtraStruct r5 = r4.d;
        if (r5 == null) goto L14;
        boolean r6 = r5.isStarAtlasTag();
    L15:
        if (r6 == false) goto L10;
        TextExtraStruct r7 = r4.d;
        if (r7 == null) goto L20;
        r7.setStart(r0.getSpanStart(r4));
    L20:
        TextExtraStruct r8 = r4.d;
        if (r8 == null) goto L24;
        r8.setEnd(r0.getSpanEnd(r4));
    L24:
        TextExtraStruct r9 = r4.d;
        if (r9 != null) goto L27;
        r9 = new TextExtraStruct();
    L27:
        r2.add(r9);
        goto L10
    L14:
        r6 = false;
        goto L15
    L28:
        return r2;
    L37:
        return null;
    L36:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Parcelable onSaveInstanceState() {
        MentionSavedState r1 = new MentionSavedState(super/*android.widget.EditText*/.onSaveInstanceState());
        r1.a = String.valueOf(getText());
        r1.b = Math.max(getSelectionEnd(), 0);
        r1.c = getCompatTextExtraStructList();
        return r1;
    }

    public final Runnable getAction() {
        return this.a;
    }

    public final boolean getHandlingMentionHint() {
        return this.d;
    }

    public final com.bytedance.awemeopen.apps.framework.comment.widget.view.c getLastSelectedRange() {
        return this.f;
    }

    public final boolean getMIsSelected() {
        return this.e;
    }

    public final int getMStarAtlasMentionTextColor() {
        return this.c;
    }

    public final int getMentionTextColor() {
        return this.b;
    }

    public final c getOnMentionInputListener() {
        return this.g;
    }

    public final List<TextWatcher> getTextWatcherList() {
        return this.i;
    }

    public MentionEditText(Context r2) {
        new LinkedHashMap();
        super(r2);
        this.i = new ArrayList();
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addTextChangedListener(TextWatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        super/*android.widget.EditText*/.addTextChangedListener(r2);
        List<TextWatcher> r0 = this.i;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.add(r2);
        return;
    L8:
        return;
    }

    public final ArrayList<TextExtraStruct> e(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "typeList");
        Editable r0 = getText();
        MentionSpan[] r1 = getMentionText();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L40;
        if (r1 == null) goto L41;
        ArrayList<TextExtraStruct> r2 = new ArrayList();
        Iterator r3 = ArrayIteratorKt.iterator(r1);
    L10:
        if (r3.hasNext() == false) goto L30;
        MentionSpan r4 = (MentionSpan) r3.next();
        int r5 = r10.length;
        boolean r6 = false;
        int r7 = 0;
    L12:
        if (r7 >= r5) goto L17;
        int r8 = r10[r7];
        if (r4.getType() == r8) goto L15;
        r7 = r7 + 1;
        goto L12
    L15:
        r6 = true;
    L17:
        if (r6 == false) goto L10;
        TextExtraStruct r9 = r4.d;
        if (r9 == null) goto L22;
        r9.setStart(r0.getSpanStart(r4));
    L22:
        TextExtraStruct r11 = r4.d;
        if (r11 == null) goto L26;
        r11.setEnd(r0.getSpanEnd(r4));
    L26:
        TextExtraStruct r12 = r4.d;
        if (r12 != null) goto L29;
        r12 = new TextExtraStruct();
    L29:
        r2.add(r12);
        goto L10
    L30:
        return r2;
    L41:
        return null;
    L40:
        return null;
    }

    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "outAttrs");
        InputConnection r3 = super.onCreateInputConnection(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new a(this, r3, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(Parcelable r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof MentionSavedState) == true) goto L6;
        super/*android.widget.EditText*/.onRestoreInstanceState(r3);
        return;
    L6:
        MentionSavedState r4 = (MentionSavedState) r3;
        super/*android.widget.EditText*/.onRestoreInstanceState(r4.getSuperState());
        setText(r4.a);
        int r0 = r4.b;
        Editable r1 = getText();
        if (r1 == null) goto L9;
        int r2 = r1.length();
    L10:
        int r5 = Math.min(r0, r2);
        if (r5 < 0) goto L13;
        setSelection(r5);
    L13:
        setTextExtraList(r4.c);
        return;
    L9:
        r2 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeTextChangedListener(TextWatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        super/*android.widget.EditText*/.removeTextChangedListener(r2);
        List<TextWatcher> r0 = this.i;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.remove(r2);
        return;
    L8:
        return;
    }

    public final void setAction(Runnable r1) {
        this.a = r1;
    }

    public final void setHandlingMentionHint(boolean r1) {
        this.d = r1;
    }

    public final void setLastSelectedRange(com.bytedance.awemeopen.apps.framework.comment.widget.view.c r1) {
        this.f = r1;
    }

    public final void setMIsSelected(boolean r1) {
        this.e = r1;
    }

    public final void setMStarAtlasMentionTextColor(int r1) {
        this.c = r1;
    }

    public final void setMentionTextColor(int r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnKeyListener(View.OnKeyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.j = r2;
        super/*android.widget.EditText*/.setOnKeyListener(r2);
    }

    public final void setOnMentionInputListener(c r1) {
        this.g = r1;
    }

    public void setTextExtraList(List<? extends TextExtraStruct> r14) {
        this.e = false;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r0 = this.h;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.clear();
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        if (r14.isEmpty() == true) goto L72;
        Editable r1 = getText();
        if (r1 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r1.toString()) == true) goto L73;
        int r2 = r1.length();
        Iterator<? extends TextExtraStruct> r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L74;
        TextExtraStruct r3 = r15.next();
        if (r3 == null) goto L17;
        if (r3.isStarAtlasTag() == false) goto L24;
        int r4 = this.c;
    L25:
        int r5 = r4;
        if (r3.getType() == 0) goto L34;
        if (r3.getType() == 6) goto L34;
        if (r3.getType() == 9) goto L34;
        if (r3.getType() != 10) goto L17;
    L34:
        if (r3.getStart() > r2) goto L17;
        if (r3.getEnd() > r2) goto L17;
        if (r3.getStart() > r3.getEnd()) goto L17;
        MentionSpan r6 = new MentionSpan(new com.bytedance.awemeopen.apps.framework.comment.widget.view.b(r5, r1.subSequence(r3.getStart(), r3.getEnd()).toString(), r3.getUserId(), r3.getType(), r3.getAtUserType(), r3.getSecUid(), r3.getUserFollowStatus(), r3));
        boolean r7 = r3.isStarAtlasTag();
        TextExtraStruct r8 = r6.d;
        if (r8 == null) goto L45;
        r8.setStarAtlasTag(r7);
    L45:
        if (TextUtils.isEmpty(r3.getAwemeId()) == true) goto L50;
        String r9 = r3.getAwemeId();
        r6.e = r9;
        TextExtraStruct r10 = r6.d;
        if (r10 == null) goto L50;
        r10.setAwemeId(r9);
    L50:
        int r11 = r3.getSubtype();
        r6.f = r11;
        TextExtraStruct r12 = r6.d;
        if (r12 == null) goto L53;
        r12.setSubType(r11);
    L53:
        r1.setSpan(r6, r3.getStart(), r3.getEnd(), 33);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r13 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r3.getStart(), r3.getEnd());
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r16 = this.h;
        Intrinsics.checkNotNull(r16);
        r16.add(r13);
        goto L17
    L24:
        r4 = this.b;
        goto L25
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L5:
        this.h = new ArrayList(5);
        goto L6
    }

    public final void setTextWatcherList(List<TextWatcher> r1) {
        this.i = r1;
    }

    public MentionEditText(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        super(r2, r3);
        this.i = new ArrayList();
        f();
    }

    public final com.bytedance.awemeopen.apps.framework.comment.widget.view.c d(int r5, int r6) {
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r0 = this.h;
        if (r0 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r0);
        Iterator<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r2 = r1.next();
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
    public void onSelectionChanged(int r8, int r9) {
        super/*android.widget.EditText*/.onSelectionChanged(r8, r9);
        if (getStarAtlasExtraList() != null) goto L5;
    L28:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r0 = this.f;
        if (r0 == null) goto L41;
        Intrinsics.checkNotNull(r0);
        int r3 = r0.a;
        if (r3 == r8) goto L33;
    L34:
        if (r3 == r9) goto L36;
    L38:
        boolean r1 = false;
    L39:
        if (r1 == false) goto L41;
        return;
    L36:
        if (r0.b != r8) goto L38;
    L37:
        r1 = true;
        goto L39
    L33:
        if (r0.b == r9) goto L37;
    L41:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r2 = d(r8, r9);
        if (r2 != null) goto L44;
    L46:
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r4 = this.h;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r5 = null;
        if (r4 == null) goto L63;
        Intrinsics.checkNotNull(r4);
        Iterator<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r6 = r4.iterator();
    L51:
        if (r6.hasNext() == false) goto L63;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r7 = r6.next();
        int r10 = r7.a;
        if (r8 > r10) goto L55;
    L56:
        if (r9 > r10) goto L58;
    L60:
        boolean r11 = false;
    L61:
        if (r11 == false) goto L51;
        r5 = r7;
        goto L63
    L58:
        if (r9 >= r7.b) goto L60;
    L59:
        r11 = true;
        goto L61
    L55:
        if (r8 < r7.b) goto L59;
    L63:
        if (r5 != null) goto L78;
        return;
    L78:
        if (r8 != r9) goto L70;
        int r12 = r5.a;     // Catch: IndexOutOfBoundsException -> L77
        int r13 = r5.b;     // Catch: IndexOutOfBoundsException -> L77
        if (((r8 - r12) - (r13 - r8)) < 0) goto L69;
        r12 = r13;
    L69:
        setSelection(r12);     // Catch: IndexOutOfBoundsException -> L77
        return;
    L70:
        int r14 = r5.b;     // Catch: IndexOutOfBoundsException -> L77
        if (r9 >= r14) goto L73;
        setSelection(r8, r14);     // Catch: IndexOutOfBoundsException -> L77
    L73:
        int r15 = r5.a;     // Catch: IndexOutOfBoundsException -> L77
        if (r8 <= r15) goto L88;
        setSelection(r15, r9);     // Catch: IndexOutOfBoundsException -> L77
        return;
    L88:
        return;
    L89:
        return;
    L44:
        if (r2.b != r9) goto L46;
        this.e = false;
        goto L46
    L5:
        if (getText() == null) goto L28;
        if (TextUtils.isEmpty(getText()) == true) goto L28;
        ArrayList<TextExtraStruct> r16 = getStarAtlasExtraList();
        Intrinsics.checkNotNull(r16);
        Iterator<TextExtraStruct> r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L28;
        TextExtraStruct r18 = r17.next();
        if (r8 >= (r18.getEnd() + 1)) goto L14;
        int r19 = r18.getEnd() + 1;
    L16:
        if (r9 >= (r18.getEnd() + 1)) goto L18;
        int r20 = r18.getEnd() + 1;
    L19:
        Editable r21 = getText();
        Intrinsics.checkNotNull(r21);
        if (r19 <= r21.length()) goto L23;
        Editable r22 = getText();
        Intrinsics.checkNotNull(r22);
        r19 = r22.length();
    L23:
        Editable r23 = getText();
        Intrinsics.checkNotNull(r23);
        if (r20 <= r23.length()) goto L27;
        Editable r24 = getText();
        Intrinsics.checkNotNull(r24);
        r20 = r24.length();
    L27:
        setSelection(r19, r20);
        goto L10
    L18:
        r20 = r9;
        goto L19
    L14:
        r19 = r8;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r2, TextView.BufferType r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "type");
        super/*android.widget.EditText*/.setText(r2, r3);     // Catch: Exception -> L5
    L7:
        if (this.a != null) goto L9;
        this.a = new d(this);
    L9:
        Editable r4 = getText();
        if (r4 == null) goto L12;
        int r5 = r4.length();
    L13:
        if (r5 > 0) goto L15;
        return;
    L15:
        if (this.d == true) goto L21;
        post(this.a);
        return;
    L21:
        return;
    L12:
        r5 = 0;
        goto L13
    }

    public MentionEditText(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        super(r2, r3, r4);
        this.i = new ArrayList();
        f();
    }

    public final void onTextChanged(CharSequence r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "text");
        int r9 = 0;
        this.e = false;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r10 = this.h;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.clear();
    L6:
        Editable r11 = getText();
        if (r11 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r11.toString()) == true) goto L28;
        MentionSpan[] r12 = getMentionText();
        if (r12 == null) goto L27;
        int r13 = r12.length;
    L14:
        if (r9 >= r13) goto L29;
        MentionSpan r0 = r12[r9];
        int r2 = r11.getSpanStart(r0);
        int r3 = r11.getSpanEnd(r0);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r1 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r2, r3);
        if (TextUtils.equals(r11.subSequence(r2, r3).toString(), r0.b) == true) goto L19;
        r11.removeSpan(r0);
    L21:
        r9 = r9 + 1;
        goto L14
    L19:
        if (g(r0.getType()) == false) goto L21;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r4 = this.h;
        Intrinsics.checkNotNull(r4);
        r4.add(r1);
        goto L21
    L29:
        return;
    L27:
        return;
    L28:
        return;
    L5:
        this.h = new ArrayList(5);
        goto L6
    }
}
