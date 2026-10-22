package com.larus.dora.impl.device.settings.gesture;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.nova.R;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0014HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "Landroid/os/Parcelable;", "role", "", "status", "gesture", "function", "<init>", "(BBBB)V", "getRole", "()B", "setRole", "(B)V", "getStatus", "setStatus", "getGesture", "setGesture", "getFunction", "setFunction", "roleText", "", "statusText", "gestureText", "functionText", "functionSubText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGGestureSettings implements Parcelable {
    public static final Parcelable.Creator<DoraGGestureSettings> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f334357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f334358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte f334359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f334360d;

    public static final class a implements Parcelable.Creator<DoraGGestureSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraGGestureSettings createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoraGGestureSettings(r100.readByte(), r100.readByte(), r100.readByte(), r100.readByte());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraGGestureSettings[] newArray(int r100) {
            return new DoraGGestureSettings[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraGGestureSettings) == true) goto L8;
        return false;
    L8:
        DoraGGestureSettings r101 = (DoraGGestureSettings) r100;
        if (this.f334357a == r101.f334357a) goto L12;
        return false;
    L12:
        if (this.f334358b == r101.f334358b) goto L15;
        return false;
    L15:
        if (this.f334359c == r101.f334359c) goto L18;
        return false;
    L18:
        if (this.f334360d == r101.f334360d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f334357a * 31) + this.f334358b) * 31) + this.f334359c) * 31) + this.f334360d;
    }

    public final String toString() {
        return "DoraGGestureSettings(role=" + this.f334357a + ", status=" + this.f334358b + ", gesture=" + this.f334359c + ", function=" + this.f334360d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeByte(this.f334357a);
        r100.writeByte(this.f334358b);
        r100.writeByte(this.f334359c);
        r100.writeByte(this.f334360d);
    }

    public final String b() {
        byte r100 = this.f334358b;
        if (r100 != 6) goto L9;
        byte r101 = this.f334359c;
        if (r101 != 2) goto L7;
    L8:
        boolean r102 = true;
    L11:
        if (r100 != 4) goto L18;
        if (this.f334359c != 2) goto L18;
        if (this.f334360d != 37) goto L18;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_g_gesture_doubleclick_record_subtitle_cn);
    L18:
        if (r102 == false) goto L23;
        if (this.f334360d != 34) goto L23;
        int r104 = j0.f375426a;
        return j0.d(R.string.larus_dora_g_gesture_touch_translate_subtitle_cn);
    L23:
        if (r102 == false) goto L28;
        if (this.f334360d != 40) goto L28;
        int r105 = j0.f375426a;
        return j0.d(R.string.larus_dora_g_gesture_touch_earmode_subtitle_cn);
    L28:
        if (r102 == true) goto L30;
    L32:
        byte r106 = this.f334360d;
        if (r106 != 37) goto L36;
        int r107 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_record_and_summary_desc_cn);
    L36:
        if (r106 != 38) goto L38;
        int r108 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_quick_note_desc_cn);
    L38:
        if (r106 != 33) goto L41;
        int r109 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_live_ai_desc_cn);
    L41:
        if (r106 != 35) goto L44;
        int r110 = j0.f375426a;
        return j0.d(R.string.larus_dora_wakeup_gesture_radio_subtitle_cn);
    L44:
        if (r106 != 32) goto L46;
        int r111 = j0.f375426a;
        return j0.d(R.string.larus_dora_wakeup_gesture_radio_continuous_dialogue_subtitle_cn);
    L46:
        if (r106 != 34) goto L49;
        int r112 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_simultaneous_interpretation_desc_cn);
    L49:
        if (r106 != 39) goto L51;
        int r113 = j0.f375426a;
        return j0.d(R.string.larus_dora_button_take_video_desc_cn);
    L51:
        if (r106 != 40) goto L53;
        int r114 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_headphone_mode_desc_cn);
    L53:
        return "";
    L30:
        if (this.f334360d != 33) goto L32;
        int r115 = j0.f375426a;
        return j0.d(R.string.larus_dora_g_gesture_touch_videocall_subtitle_cn);
    L7:
        if (r101 == 3) goto L8;
    L9:
        r102 = false;
        goto L11
    }

    public final String c() {
        byte r100 = this.f334358b;
        if (r100 != 6) goto L24;
        byte r101 = this.f334360d;
        if (r101 != 16) goto L8;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_play_or_pause_cn);
    L8:
        if (r101 != 19) goto L11;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_previous_cn);
    L11:
        if (r101 != 20) goto L13;
        int r104 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_next_cn);
    L13:
        if (r101 != 6) goto L15;
        int r105 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_volume_cn);
    L15:
        if (r101 != 34) goto L17;
        int r106 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_simultaneous_interpretation_cn);
    L17:
        if (r101 != 40) goto L19;
        int r107 = j0.f375426a;
        return j0.d(R.string.larus_dora_headphone_mode_cn);
    L19:
        if (r101 != 33) goto L21;
        int r108 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_live_ai_cn);
    L21:
        if (r101 != 0) goto L70;
        int r109 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_none_cn);
    L70:
        return "";
    L24:
        if (r100 != 1) goto L38;
        byte r110 = this.f334360d;
        if (r110 != 1) goto L28;
        int r111 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_hang_up_or_answer_cn);
    L28:
        if (r110 != 2) goto L31;
        int r112 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_answer_cn);
    L31:
        if (r110 != 3) goto L33;
        int r113 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_hang_up_cn);
    L33:
        if (r110 != 4) goto L35;
        int r114 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_reject_cn);
    L35:
        if (r110 != 0) goto L70;
        int r115 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_none_cn);
    L38:
        if (r100 != 2) goto L59;
        byte r116 = this.f334360d;
        if (r116 != 33) goto L43;
        int r117 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_live_ai_cn);
    L43:
        if (r116 != 35) goto L46;
        int r118 = j0.f375426a;
        return j0.d(R.string.larus_dora_wakeup_gesture_radio_title_cn);
    L46:
        if (r116 != 32) goto L48;
        int r119 = j0.f375426a;
        return j0.d(R.string.larus_dora_wakeup_gesture_radio_continuous_dialogue_title_cn);
    L48:
        if (r116 != 34) goto L50;
        int r120 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_simultaneous_interpretation_cn);
    L50:
        if (r116 != 37) goto L53;
        int r121 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_record_and_summary_cn);
    L53:
        if (r116 != 38) goto L55;
        int r122 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_quick_note_cn);
    L55:
        if (r116 != 40) goto L57;
        int r123 = j0.f375426a;
        return j0.d(R.string.larus_dora_headphone_mode_cn);
    L57:
        if (r116 != 0) goto L70;
        int r124 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_none_cn);
    L59:
        if (r100 != 4) goto L70;
        byte r125 = this.f334360d;
        if (r125 != 33) goto L63;
        int r126 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_live_ai_cn);
    L63:
        if (r125 != 37) goto L66;
        int r127 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_record_and_summary_cn);
    L66:
        if (r125 != 39) goto L68;
        int r128 = j0.f375426a;
        return j0.d(R.string.larus_dora_button_take_video_cn);
    L68:
        if (r125 != 0) goto L70;
        int r129 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_none_cn);
    }

    public final String d() {
        byte r100 = this.f334359c;
        if (r100 != 1) goto L6;
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_click_cn);
    L6:
        if (r100 != 2) goto L9;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_double_click_cn);
    L9:
        if (r100 != 3) goto L12;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_triple_click_cn);
    L12:
        if (r100 != 16) goto L15;
        int r104 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_slide_cn);
    L15:
        if (r100 != 6) goto L17;
        int r105 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_press_and_hold_cn);
    L17:
        return "";
    }

    public final String e() {
        byte r100 = this.f334357a;
        if (r100 != 16) goto L5;
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_left_temple_cn);
    L5:
        if (r100 != 0) goto L7;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_right_temple_cn);
    L7:
        return "";
    }

    public final String g() {
        byte r100 = this.f334358b;
        if (r100 != 6) goto L6;
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_g_gesture_grouptitle_shortcut__cn);
    L6:
        if (r100 != 1) goto L9;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_lite_cn);
    L9:
        if (r100 != 2) goto L11;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_conversation_lite_cn);
    L11:
        return "";
    }

    public static DoraGGestureSettings a(DoraGGestureSettings r100, byte r101, int r102) {
        byte r103 = 0;
        if ((r102 & 1) == 0) goto L5;
        byte r104 = r100.f334357a;
    L7:
        if ((r102 & 2) == 0) goto L9;
        byte r105 = r100.f334358b;
    L11:
        if ((r102 & 4) == 0) goto L14;
        r103 = r100.f334359c;
    L14:
        if ((r102 & 8) == 0) goto L16;
        r101 = r100.f334360d;
    L16:
        r100.getClass();
        return new DoraGGestureSettings(r104, r105, r103, r101);
    L9:
        r105 = 0;
        goto L11
    L5:
        r104 = 0;
        goto L7
    }

    public DoraGGestureSettings(byte r100, byte r101, byte r102, byte r103) {
        this.f334357a = r100;
        this.f334358b = r101;
        this.f334359c = r102;
        this.f334360d = r103;
    }
}
