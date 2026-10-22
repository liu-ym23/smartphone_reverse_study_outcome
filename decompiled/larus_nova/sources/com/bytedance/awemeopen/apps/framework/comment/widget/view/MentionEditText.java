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
import androidx.core.view.GravityCompat;
import com.amap.api.col.s.ce;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.awemeopen.apps.framework.comment.widget.DmtEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0006\u000bYZ\u0013\u001a\u001fB\u0013\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SB\u001d\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bR\u0010VB%\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\u0012¢\u0006\u0004\bR\u0010XJ\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010B\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001e\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bG\u0010?R\u0019\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010C8F¢\u0006\u0006\u001a\u0004\bI\u0010ER\u0019\u0010O\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010K8F¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006["}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText;", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/DmtEditText;", "", "Lcom/bytedance/awemeopen/apps/framework/comment/write/model/TextExtraStruct;", "structList", "", "setTextExtraList", "Landroid/view/View$OnKeyListener;", "l", "setOnKeyListener", "Ljava/lang/Runnable;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Runnable;", "getAction", "()Ljava/lang/Runnable;", "setAction", "(Ljava/lang/Runnable;)V", "action", "", "b", "I", "getMentionTextColor", "()I", "setMentionTextColor", "(I)V", "mentionTextColor", "c", "getMStarAtlasMentionTextColor", "setMStarAtlasMentionTextColor", "mStarAtlasMentionTextColor", "", "d", "Z", "getHandlingMentionHint", "()Z", "setHandlingMentionHint", "(Z)V", "handlingMentionHint", "e", "getMIsSelected", "setMIsSelected", "mIsSelected", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "f", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "getLastSelectedRange", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;", "setLastSelectedRange", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/c;)V", "lastSelectedRange", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", ce.f26391f, "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", "getOnMentionInputListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;", "setOnMentionInputListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$c;)V", "onMentionInputListener", "", "Landroid/text/TextWatcher;", RXScreenCaptureService.KEY_INDEX, "Ljava/util/List;", "getTextWatcherList", "()Ljava/util/List;", "setTextWatcherList", "(Ljava/util/List;)V", "textWatcherList", "Ljava/util/ArrayList;", "getTextExtraStructList", "()Ljava/util/ArrayList;", "textExtraStructList", "getCompatTextExtraStructList", "compatTextExtraStructList", "getStarAtlasExtraList", "starAtlasExtraList", "", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "getMentionText", "()[Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "mentionText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MentionSavedState", "MentionSpan", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class MentionEditText extends DmtEditText {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f194328k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f194329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f194330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f194331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f194332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f194333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.comment.widget.view.c f194334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f194335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> f194336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<TextWatcher> f194337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnKeyListener f194338j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSavedState;", "Landroid/view/View$BaseSavedState;", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class MentionSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MentionSavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f194339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f194340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<? extends TextExtraStruct> f194341c;

        public static final class a implements Parcelable.Creator<MentionSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "in");
                return new MentionSavedState(r100);
            L5:
                return null;
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState[] newArray(int r100) {
                return new MentionSavedState[r100];
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public MentionSavedState(Parcel r100) {
            super(r100);
            this.f194339a = r100.readString();
            this.f194340b = r100.readInt();
            Bundle r101 = r100.readBundle(MentionSavedState.class.getClassLoader());
            if (r101 == null) goto L6;
            this.f194341c = r101.getParcelableArrayList("text_extra_struct");
            return;
        }

        public MentionSavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            super.writeToParcel(r100, r101);
            r100.writeString(this.f194339a);
            r100.writeInt(this.f194340b);
            Bundle r102 = new Bundle();
            r102.putParcelableArrayList("text_extra_struct", (ArrayList) this.f194341c);
            r100.writeBundle(r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/MentionEditText$MentionSpan;", "Landroid/text/style/ForegroundColorSpan;", "", "c", "I", "getType", "()I", "setType", "(I)V", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class MentionSpan extends ForegroundColorSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f194342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f194343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f194344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextExtraStruct f194345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f194346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f194347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f194348g;

        public static final class a {
        }

        static {
        }

        @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int hashCode() {
            String r100 = this.f194342a;
            int r101 = 0;
            if (r100 == null) goto L6;
            if (r100 == null) goto L6;
            int r102 = r100.hashCode();
        L7:
            int r103 = r102 * 31;
            String r104 = this.f194343b;
            if (r104 == null) goto L11;
            if (r104 == null) goto L11;
            int r105 = r104.hashCode();
        L12:
            int r106 = (((r103 + r105) * 31) + this.f194344c) * 31;
            TextExtraStruct r107 = this.f194345d;
            if (r107 == null) goto L16;
            if (r107 == null) goto L16;
            int r108 = r107.hashCode();
        L17:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f194346e;
            if (r110 == null) goto L21;
            if (r110 == null) goto L21;
            int r111 = r110.hashCode();
        L22:
            int r112 = (((r109 + r111) * 31) + this.f194347f) * 31;
            String r113 = this.f194348g;
            if (r113 == null) goto L27;
            if (r113 == null) goto L27;
            r101 = r113.hashCode();
        L27:
            return r112 + r101;
        L21:
            r111 = 0;
        L16:
            r108 = 0;
        L11:
            r105 = 0;
        L6:
            r102 = 0;
            goto L7
        }

        public final int getType() {
            return this.f194344c;
        }

        public MentionSpan(com.bytedance.awemeopen.apps.framework.comment.widget.view.b r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            super(r100.f194354a);
            this.f194346e = "";
            this.f194348g = "";
            this.f194342a = r100.f194356c;
            this.f194343b = r100.f194355b;
            this.f194344c = r100.getType();
            String r101 = r100.f194359f;
            this.f194348g = r101;
            TextExtraStruct r102 = this.f194345d;
            if (r102 == null) goto L6;
            r102.setSecUid(r101);
        L6:
            TextExtraStruct r103 = r100.f194361h;
            if (r103 != null) goto L9;
            TextExtraStruct r104 = new TextExtraStruct();
            this.f194345d = r104;
            r104.setUserId(r100.f194356c);
            r104.setType(r100.getType());
            r104.setAtUserType(r100.f194358e);
            r104.setSecUid(r100.f194356c);
            r104.setUserUserFollowStatus(r100.f194360g);
            return;
        L9:
            this.f194345d = r103;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L67:
            return false;
        L8:
            if (Intrinsics.areEqual(MentionSpan.class, r100.getClass()) == false) goto L67;
            MentionSpan r101 = (MentionSpan) r100;
            if (this.f194344c == r101.f194344c) goto L14;
            return false;
        L14:
            if (this.f194347f == r101.f194347f) goto L16;
            return false;
        L16:
            String r102 = this.f194342a;
            if (r102 == null) goto L22;
            if (Intrinsics.areEqual(r102, r101.f194342a) == false) goto L23;
        L24:
            boolean r103 = false;
        L25:
            if (r103 == false) goto L27;
            return false;
        L27:
            String r104 = this.f194343b;
            if (r104 == null) goto L33;
            if (Intrinsics.areEqual(r104, r101.f194343b) == false) goto L34;
        L35:
            boolean r105 = false;
        L36:
            if (r105 == false) goto L38;
            return false;
        L38:
            TextExtraStruct r106 = this.f194345d;
            if (r106 == null) goto L44;
            if (Intrinsics.areEqual(r106, r101.f194345d) == false) goto L45;
        L46:
            boolean r107 = false;
        L47:
            if (r107 == false) goto L49;
            return false;
        L49:
            String r108 = this.f194346e;
            if (r108 == null) goto L55;
            if (Intrinsics.areEqual(r108, r101.f194346e) == false) goto L56;
        L57:
            boolean r109 = false;
        L58:
            if (r109 == false) goto L60;
            return false;
        L60:
            String r110 = this.f194348g;
            String r111 = r101.f194348g;
            if (r110 != null) goto L68;
            if (r111 == null) goto L69;
            return false;
        L69:
            return true;
        L68:
            return Intrinsics.areEqual(r110, r111);
        L56:
            r109 = true;
            goto L58
        L55:
            if (r101.f194346e == null) goto L57;
        L45:
            r107 = true;
            goto L47
        L44:
            if (r101.f194345d == null) goto L46;
        L34:
            r105 = true;
            goto L36
        L33:
            if (r101.f194343b == null) goto L35;
        L23:
            r103 = true;
            goto L25
        L22:
            if (r101.f194342a == null) goto L24;
            goto L23
        }

        @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f194342a);
            r100.writeString(this.f194343b);
            r100.writeInt(this.f194344c);
            r100.writeParcelable(this.f194345d, r101);
            r100.writeString(this.f194348g);
        }
    }

    public final class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MentionEditText f194349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MentionEditText f194350b;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            View.OnKeyListener r101 = this.f194350b.f194338j;
            if (r101 == null) goto L7;
            Intrinsics.checkNotNull(r101);
            return r101.onKey(this.f194350b, r100.getKeyCode(), r100);
        L7:
            if (r100.getAction() != 0) goto L27;
            if (r100.getKeyCode() != 67) goto L27;
            int r102 = this.f194349a.getSelectionStart();
            int r103 = this.f194349a.getSelectionEnd();
            com.bytedance.awemeopen.apps.framework.comment.widget.view.c r104 = this.f194350b.d(r102, r103);
            if (r104 != null) goto L15;
            this.f194350b.setMIsSelected(false);
            return super.sendKeyEvent(r100);
        L15:
            if (this.f194350b.getMIsSelected() == false) goto L17;
        L24:
            this.f194350b.setMIsSelected(false);
            return super.sendKeyEvent(r100);
        L17:
            if (r102 == r104.f194362a) goto L24;
            this.f194350b.setMIsSelected(true);
            this.f194350b.setLastSelectedRange(r104);
            if (Build.VERSION.SDK_INT < 25) goto L22;
            setSelection(r104.f194362a, r104.f194363b);
        L23:
            return true;
        L22:
            setSelection(r104.f194363b, r104.f194362a);
        L27:
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            if (r100 != null) goto L8;
            return true;
        L8:
            return super.commitText(r100, r101);
        L10:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r110, int r111) {
            if (r110 != 1) goto L46;
            if (r111 != 0) goto L46;
            Editable r100 = this.f194350b.getText();
            if (r100 != null) goto L8;
        L45:
            return false;
        L8:
            if (r100.length() <= 0) goto L45;
            MentionEditText r101 = this.f194350b;
            int r102 = MentionEditText.f194328k;
            r101.getClass();
            int r103 = r100.length();
            int r112 = Math.max(r101.getSelectionStart() - r110, 0);
            int r113 = Math.min(r101.getSelectionEnd() + r111, r103);
            CharacterStyle[] r104 = (CharacterStyle[]) r100.getSpans(0, r103, CharacterStyle.class);
            int r105 = r104.length;
            int r106 = r112;
            int r107 = r113;
            int r108 = 0;
            boolean r109 = false;
            boolean r114 = false;
        L10:
            if (r108 >= r105) goto L29;
            CharacterStyle r115 = r104[r108];
            if ((r115 instanceof MentionSpan) == true) goto L14;
        L16:
            int r116 = r100.getSpanStart(r115);
            int r117 = r100.getSpanEnd(r115);
            if (r109 == true) goto L21;
            if (r116 > r112) goto L21;
            if (r117 <= r112) goto L21;
            r106 = r116;
            r109 = true;
        L21:
            if (r114 == true) goto L25;
            if (r116 >= r113) goto L25;
            if (r117 < r113) goto L25;
            r107 = r117;
            r114 = true;
        L25:
            if (r109 == false) goto L28;
            if (r114 == true) goto L29;
        L28:
            r108 = r108 + 1;
            goto L10
        L14:
            if (((MentionSpan) r115).getType() != 1) goto L16;
        L29:
            if (r106 <= r107) goto L31;
            int r118 = r107;
            r107 = r106;
            r106 = r118;
        L31:
            com.bytedance.awemeopen.apps.framework.comment.widget.view.c r119 = this.f194350b.d(r106, r107);
            if (r119 == null) goto L44;
            MentionSpan[] r120 = (MentionSpan[]) r100.getSpans(r119.f194362a, r119.f194363b, MentionSpan.class);
            if (r120 == null) goto L44;
            if (r120.length <= 0) goto L44;
            if (sendKeyEvent(new KeyEvent(0, 67)) == true) goto L40;
        L42:
            return false;
        L40:
            if (sendKeyEvent(new KeyEvent(1, 67)) == false) goto L42;
            return true;
        L44:
            r100.delete(r106, r107);
        L46:
            if (r110 >= 0) goto L49;
            int r121 = -r111;
            r111 = -r110;
            r110 = r121;
        L49:
            return super.deleteSurroundingText(r110, r111);
        }

        public a(MentionEditText r100, InputConnection r101, MentionEditText r102) {
            Intrinsics.checkNotNullParameter(r102, "editText");
            this.f194350b = r100;
            super(r101, true);
            this.f194349a = r102;
        }
    }

    public final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MentionEditText f194351a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Intrinsics.checkNotNullParameter(r100, "editable");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "charSequence");
        }

        public b(MentionEditText r100) {
            this.f194351a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "charSequence");
            if (r103 == 1) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r100) == false) goto L7;
            return;
        L7:
            if ('@' == r100.toString().charAt(r101)) goto L9;
            return;
        L9:
            if (this.f194351a.getOnMentionInputListener() == null) goto L15;
            c r104 = this.f194351a.getOnMentionInputListener();
            Intrinsics.checkNotNull(r104);
            r104.a();
            return;
        }
    }

    public interface c {
        void a();
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<MentionEditText> f194352a;

        @Override // java.lang.Runnable
        public final void run() {
            MentionEditText r100 = this.f194352a.get();     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            Editable r101 = r100.getText();     // Catch: Throwable -> L10
            if (r101 == null) goto L7;
            int r102 = r101.length();     // Catch: Throwable -> L10
        L8:
            r100.setSelection(r102);     // Catch: Throwable -> L10
            return;
        L7:
            r102 = 0;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(MentionEditText r100) {
            Intrinsics.checkNotNullParameter(r100, "editText");
            this.f194352a = new WeakReference(r100);
        }
    }

    public boolean g(int r100) {
        if (r100 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        return e(new int[]{0});
    }

    public final void f() {
        this.f194336h = new ArrayList(5);
        this.f194330b = -65536;
        addTextChangedListener(new b(this));
        Context r100 = getContext();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getResources().getConfiguration().getLayoutDirection() != 1) goto L7;
    L8:
        if (r101 == false) goto L11;
        setTextAlignment(5);
        setGravity(getGravity() | GravityCompat.START);
        return;
    L11:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final List<TextExtraStruct> getCompatTextExtraStructList() {
        return getTextExtraStructList();
    }

    public final MentionSpan[] getMentionText() {
        final Editable r100 = getText();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L11;
        MentionSpan[] r101 = (MentionSpan[]) r100.getSpans(0, r100.length(), MentionSpan.class);
        final Function2<MentionSpan, MentionSpan, Integer> r102 = new MentionEditText$mentionText$1(r100);
        Arrays.sort(r101, new com.bytedance.awemeopen.apps.framework.comment.widget.view.a(r102));
        return r101;
    L11:
        return null;
    }

    public final ArrayList<TextExtraStruct> getStarAtlasExtraList() {
        Editable r100 = getText();
        MentionSpan[] r101 = getMentionText();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L36;
        if (r101 == null) goto L37;
        ArrayList<TextExtraStruct> r102 = new ArrayList();
        Iterator r103 = ArrayIteratorKt.iterator(r101);
    L10:
        if (r103.hasNext() == false) goto L28;
        MentionSpan r104 = (MentionSpan) r103.next();
        TextExtraStruct r105 = r104.f194345d;
        if (r105 == null) goto L14;
        boolean r106 = r105.isStarAtlasTag();
    L15:
        if (r106 == false) goto L10;
        TextExtraStruct r107 = r104.f194345d;
        if (r107 == null) goto L20;
        r107.setStart(r100.getSpanStart(r104));
    L20:
        TextExtraStruct r108 = r104.f194345d;
        if (r108 == null) goto L24;
        r108.setEnd(r100.getSpanEnd(r104));
    L24:
        TextExtraStruct r109 = r104.f194345d;
        if (r109 != null) goto L27;
        r109 = new TextExtraStruct();
    L27:
        r102.add(r109);
        goto L10
    L14:
        r106 = false;
        goto L15
    L28:
        return r102;
    L37:
        return null;
    L36:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        MentionSavedState r100 = new MentionSavedState(super.onSaveInstanceState());
        r100.f194339a = String.valueOf(getText());
        r100.f194340b = Math.max(getSelectionEnd(), 0);
        r100.f194341c = getCompatTextExtraStructList();
        return r100;
    }

    public final Runnable getAction() {
        return this.f194329a;
    }

    public final boolean getHandlingMentionHint() {
        return this.f194332d;
    }

    public final com.bytedance.awemeopen.apps.framework.comment.widget.view.c getLastSelectedRange() {
        return this.f194334f;
    }

    public final boolean getMIsSelected() {
        return this.f194333e;
    }

    public final int getMStarAtlasMentionTextColor() {
        return this.f194331c;
    }

    public final int getMentionTextColor() {
        return this.f194330b;
    }

    public final c getOnMentionInputListener() {
        return this.f194335g;
    }

    public final List<TextWatcher> getTextWatcherList() {
        return this.f194337i;
    }

    public MentionEditText(Context r100) {
        new LinkedHashMap();
        super(r100);
        this.f194337i = new ArrayList();
        f();
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        super.addTextChangedListener(r100);
        List<TextWatcher> r101 = this.f194337i;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.add(r100);
        return;
    L8:
        return;
    }

    public final ArrayList<TextExtraStruct> e(int... r110) {
        Intrinsics.checkNotNullParameter(r110, "typeList");
        Editable r100 = getText();
        MentionSpan[] r101 = getMentionText();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L40;
        if (r101 == null) goto L41;
        ArrayList<TextExtraStruct> r102 = new ArrayList();
        Iterator r103 = ArrayIteratorKt.iterator(r101);
    L10:
        if (r103.hasNext() == false) goto L30;
        MentionSpan r104 = (MentionSpan) r103.next();
        int r105 = r110.length;
        boolean r106 = false;
        int r107 = 0;
    L12:
        if (r107 >= r105) goto L17;
        int r108 = r110[r107];
        if (r104.getType() == r108) goto L15;
        r107 = r107 + 1;
        goto L12
    L15:
        r106 = true;
    L17:
        if (r106 == false) goto L10;
        TextExtraStruct r109 = r104.f194345d;
        if (r109 == null) goto L22;
        r109.setStart(r100.getSpanStart(r104));
    L22:
        TextExtraStruct r111 = r104.f194345d;
        if (r111 == null) goto L26;
        r111.setEnd(r100.getSpanEnd(r104));
    L26:
        TextExtraStruct r112 = r104.f194345d;
        if (r112 != null) goto L29;
        r112 = new TextExtraStruct();
    L29:
        r102.add(r112);
        goto L10
    L30:
        return r102;
    L41:
        return null;
    L40:
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new a(this, r101, this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof MentionSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        MentionSavedState r101 = (MentionSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setText(r101.f194339a);
        int r102 = r101.f194340b;
        Editable r103 = getText();
        if (r103 == null) goto L9;
        int r104 = r103.length();
    L10:
        int r105 = Math.min(r102, r104);
        if (r105 < 0) goto L13;
        setSelection(r105);
    L13:
        setTextExtraList(r101.f194341c);
        return;
    L9:
        r104 = 0;
        goto L10
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        super.removeTextChangedListener(r100);
        List<TextWatcher> r101 = this.f194337i;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.remove(r100);
        return;
    L8:
        return;
    }

    public final void setAction(Runnable r100) {
        this.f194329a = r100;
    }

    public final void setHandlingMentionHint(boolean r100) {
        this.f194332d = r100;
    }

    public final void setLastSelectedRange(com.bytedance.awemeopen.apps.framework.comment.widget.view.c r100) {
        this.f194334f = r100;
    }

    public final void setMIsSelected(boolean r100) {
        this.f194333e = r100;
    }

    public final void setMStarAtlasMentionTextColor(int r100) {
        this.f194331c = r100;
    }

    public final void setMentionTextColor(int r100) {
        this.f194330b = r100;
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f194338j = r100;
        super.setOnKeyListener(r100);
    }

    public final void setOnMentionInputListener(c r100) {
        this.f194335g = r100;
    }

    public void setTextExtraList(List<? extends TextExtraStruct> r110) {
        this.f194333e = false;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r100 = this.f194336h;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.clear();
    L6:
        if (r110 != null) goto L8;
        return;
    L8:
        if (r110.isEmpty() == true) goto L72;
        Editable r101 = getText();
        if (r101 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r101.toString()) == true) goto L73;
        int r102 = r101.length();
        Iterator<? extends TextExtraStruct> r111 = r110.iterator();
    L17:
        if (r111.hasNext() == false) goto L74;
        TextExtraStruct r103 = r111.next();
        if (r103 == null) goto L17;
        if (r103.isStarAtlasTag() == false) goto L24;
        int r104 = this.f194331c;
    L25:
        int r105 = r104;
        if (r103.getType() == 0) goto L34;
        if (r103.getType() == 6) goto L34;
        if (r103.getType() == 9) goto L34;
        if (r103.getType() != 10) goto L17;
    L34:
        if (r103.getStart() > r102) goto L17;
        if (r103.getEnd() > r102) goto L17;
        if (r103.getStart() > r103.getEnd()) goto L17;
        MentionSpan r106 = new MentionSpan(new com.bytedance.awemeopen.apps.framework.comment.widget.view.b(r105, r101.subSequence(r103.getStart(), r103.getEnd()).toString(), r103.getUserId(), r103.getType(), r103.getAtUserType(), r103.getSecUid(), r103.getUserFollowStatus(), r103));
        boolean r107 = r103.isStarAtlasTag();
        TextExtraStruct r108 = r106.f194345d;
        if (r108 == null) goto L45;
        r108.setStarAtlasTag(r107);
    L45:
        if (TextUtils.isEmpty(r103.getAwemeId()) == true) goto L50;
        String r109 = r103.getAwemeId();
        r106.f194346e = r109;
        TextExtraStruct r112 = r106.f194345d;
        if (r112 == null) goto L50;
        r112.setAwemeId(r109);
    L50:
        int r113 = r103.getSubtype();
        r106.f194347f = r113;
        TextExtraStruct r114 = r106.f194345d;
        if (r114 == null) goto L53;
        r114.setSubType(r113);
    L53:
        r101.setSpan(r106, r103.getStart(), r103.getEnd(), 33);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r115 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r103.getStart(), r103.getEnd());
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r116 = this.f194336h;
        Intrinsics.checkNotNull(r116);
        r116.add(r115);
        goto L17
    L24:
        r104 = this.f194330b;
        goto L25
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L5:
        this.f194336h = new ArrayList(5);
        goto L6
    }

    public final void setTextWatcherList(List<TextWatcher> r100) {
        this.f194337i = r100;
    }

    public MentionEditText(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        super(r100, r101);
        this.f194337i = new ArrayList();
        f();
    }

    public final com.bytedance.awemeopen.apps.framework.comment.widget.view.c d(int r100, int r101) {
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r102 = this.f194336h;
        if (r102 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r102);
        Iterator<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r104 = r103.next();
        if (r104.f194362a <= r100) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L7;
        return r104;
    L11:
        if (r104.f194363b < r101) goto L13;
        r105 = true;
        goto L14
    L16:
        return null;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        if (getStarAtlasExtraList() != null) goto L5;
    L28:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r102 = this.f194334f;
        if (r102 == null) goto L41;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.f194362a;
        if (r103 == r100) goto L33;
    L34:
        if (r103 == r101) goto L36;
    L38:
        boolean r104 = false;
    L39:
        if (r104 == false) goto L41;
        return;
    L36:
        if (r102.f194363b != r100) goto L38;
    L37:
        r104 = true;
        goto L39
    L33:
        if (r102.f194363b == r101) goto L37;
    L41:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r105 = d(r100, r101);
        if (r105 != null) goto L44;
    L46:
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r106 = this.f194336h;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r107 = null;
        if (r106 == null) goto L63;
        Intrinsics.checkNotNull(r106);
        Iterator<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r108 = r106.iterator();
    L51:
        if (r108.hasNext() == false) goto L63;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r109 = r108.next();
        int r110 = r109.f194362a;
        if (r100 > r110) goto L55;
    L56:
        if (r101 > r110) goto L58;
    L60:
        boolean r111 = false;
    L61:
        if (r111 == false) goto L51;
        r107 = r109;
        goto L63
    L58:
        if (r101 >= r109.f194363b) goto L60;
    L59:
        r111 = true;
        goto L61
    L55:
        if (r100 < r109.f194363b) goto L59;
    L63:
        if (r107 != null) goto L78;
        return;
    L78:
        if (r100 != r101) goto L70;
        int r112 = r107.f194362a;     // Catch: IndexOutOfBoundsException -> L77
        int r113 = r107.f194363b;     // Catch: IndexOutOfBoundsException -> L77
        if (((r100 - r112) - (r113 - r100)) < 0) goto L69;
        r112 = r113;
    L69:
        setSelection(r112);     // Catch: IndexOutOfBoundsException -> L77
        return;
    L70:
        int r114 = r107.f194363b;     // Catch: IndexOutOfBoundsException -> L77
        if (r101 >= r114) goto L73;
        setSelection(r100, r114);     // Catch: IndexOutOfBoundsException -> L77
    L73:
        int r115 = r107.f194362a;     // Catch: IndexOutOfBoundsException -> L77
        if (r100 <= r115) goto L88;
        setSelection(r115, r101);     // Catch: IndexOutOfBoundsException -> L77
        return;
    L88:
        return;
    L89:
        return;
    L44:
        if (r105.f194363b != r101) goto L46;
        this.f194333e = false;
        goto L46
    L5:
        if (getText() == null) goto L28;
        if (TextUtils.isEmpty(getText()) == true) goto L28;
        ArrayList<TextExtraStruct> r116 = getStarAtlasExtraList();
        Intrinsics.checkNotNull(r116);
        Iterator<TextExtraStruct> r117 = r116.iterator();
    L10:
        if (r117.hasNext() == false) goto L28;
        TextExtraStruct r118 = r117.next();
        if (r100 >= (r118.getEnd() + 1)) goto L14;
        int r119 = r118.getEnd() + 1;
    L16:
        if (r101 >= (r118.getEnd() + 1)) goto L18;
        int r120 = r118.getEnd() + 1;
    L19:
        Editable r121 = getText();
        Intrinsics.checkNotNull(r121);
        if (r119 <= r121.length()) goto L23;
        Editable r122 = getText();
        Intrinsics.checkNotNull(r122);
        r119 = r122.length();
    L23:
        Editable r123 = getText();
        Intrinsics.checkNotNull(r123);
        if (r120 <= r123.length()) goto L27;
        Editable r124 = getText();
        Intrinsics.checkNotNull(r124);
        r120 = r124.length();
    L27:
        setSelection(r119, r120);
        goto L10
    L18:
        r120 = r101;
        goto L19
    L14:
        r119 = r100;
        goto L16
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "type");
        super.setText(r100, r101);     // Catch: Exception -> L5
    L7:
        if (this.f194329a != null) goto L9;
        this.f194329a = new d(this);
    L9:
        Editable r102 = getText();
        if (r102 == null) goto L12;
        int r103 = r102.length();
    L13:
        if (r103 > 0) goto L15;
        return;
    L15:
        if (this.f194332d == true) goto L21;
        post(this.f194329a);
        return;
    L21:
        return;
    L12:
        r103 = 0;
        goto L13
    }

    public MentionEditText(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f194337i = new ArrayList();
        f();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r104 = 0;
        this.f194333e = false;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r105 = this.f194336h;
        if (r105 == null) goto L5;
        Intrinsics.checkNotNull(r105);
        r105.clear();
    L6:
        Editable r106 = getText();
        if (r106 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r106.toString()) == true) goto L28;
        MentionSpan[] r107 = getMentionText();
        if (r107 == null) goto L27;
        int r108 = r107.length;
    L14:
        if (r104 >= r108) goto L29;
        MentionSpan r109 = r107[r104];
        int r110 = r106.getSpanStart(r109);
        int r111 = r106.getSpanEnd(r109);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.c r112 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.c(r110, r111);
        if (TextUtils.equals(r106.subSequence(r110, r111).toString(), r109.f194343b) == true) goto L19;
        r106.removeSpan(r109);
    L21:
        r104 = r104 + 1;
        goto L14
    L19:
        if (g(r109.getType()) == false) goto L21;
        List<com.bytedance.awemeopen.apps.framework.comment.widget.view.c> r113 = this.f194336h;
        Intrinsics.checkNotNull(r113);
        r113.add(r112);
        goto L21
    L29:
        return;
    L27:
        return;
    L28:
        return;
    L5:
        this.f194336h = new ArrayList(5);
        goto L6
    }
}
