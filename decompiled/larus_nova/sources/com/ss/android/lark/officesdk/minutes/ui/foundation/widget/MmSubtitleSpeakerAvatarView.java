package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0007J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0016H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSubtitleSpeakerAvatarView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scdAvatarDrawableCache", "Landroid/util/SparseArray;", "Landroid/graphics/drawable/Drawable;", "avatarImageView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "scdAvatarContainer", "Landroid/view/View;", "scdLabel", "Landroid/widget/TextView;", "userInfoHelper", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/user/IMmUserInfoHelper;", "meetingId", "", "setUserInfoHelper", "", "helper", "bind", "avatar", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmDisplayAvatar;", "sizePx", "bindAvatarKey", "key", "userId", "bindAvatarUrl", "url", "bindPlaceholder", "avatarPlaceholderResId", "bindScdAvatar", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSubtitleSpeakerAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Drawable> f435708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIRoundedImageView f435709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f435710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f435711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a f435712e;

    public MmSubtitleSpeakerAvatarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmSubtitleSpeakerAvatarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a() {
        com.ss.android.lark.officesdk.minutes.ui.style.e r100 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r101 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(getContext());
        r100.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.b(r101).getDrawable().k();
    }

    public final void b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "avatar");
        int r100 = 1;
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C5190b) == false) goto L14;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C5190b r112 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C5190b) r110;
        String r101 = r112.f435197a;
        String r102 = r112.f435198b;
        this.f435710c.setVisibility(8);
        this.f435709b.setVisibility(0);
        int r113 = a();
        if (r101.length() == 0) goto L8;
        r100 = 0;
    L8:
        if (r100 == 0) goto L10;
        this.f435709b.setImageResource(r113);
        return;
    L10:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a r114 = this.f435712e;
        if (r114 == null) goto L73;
        r114.b(this.f435709b, new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.b(r101, r102, r111, r111, r113, r113));
        return;
    L73:
        return;
    L14:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.d) == false) goto L26;
        String r103 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.d) r110).f435200a;
        this.f435710c.setVisibility(8);
        this.f435709b.setVisibility(0);
        int r104 = a();
        if (r103.length() == 0) goto L19;
        r100 = 0;
    L19:
        if (r100 == 0) goto L21;
        this.f435709b.setImageResource(r104);
        return;
    L21:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a r115 = this.f435712e;
        if (r115 == null) goto L24;
        r115.a(this.f435709b, new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.c(r103, r111, r111, r104, r104));
        return;
    L24:
        this.f435709b.setImageResource(r104);
        return;
    L26:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e) == false) goto L67;
        String r116 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e) r110).f435201a;
        this.f435709b.setVisibility(8);
        this.f435710c.setVisibility(0);
        if (this.f435711d.getVisibility() == 8) goto L30;
        this.f435711d.setVisibility(8);
    L30:
        int r117 = fwb.a.f479044a;
        Drawable r118 = null;
        if (r116 != null) goto L33;
    L35:
        boolean r105 = false;
    L36:
        if (r105 == true) goto L43;
        if (r116 == null) goto L42;
        Integer r119 = StringsKt.toIntOrNull(r116);
        if (r119 == null) goto L42;
        r100 = r119.intValue();
    L42:
        r100 = 0;
    L43:
        int r106 = r100 % 10;
        if (r106 == 0) goto L55;
        switch(r106) {
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            default: goto L46;
        };
    L46:
        int r120 = R.drawable.office_sdk_mm_subtitle_speaker_1;
    L56:
        Drawable r107 = this.f435708a.get(r120);
        if (r107 != null) goto L61;
        r107 = ContextCompat.getDrawable(getContext(), r120);
        if (r107 == null) goto L62;
        this.f435708a.put(r120, r107);
    L62:
        if (r118 != null) goto L64;
        return;
    L64:
        if (this.f435710c.getBackground() == r118) goto L79;
        this.f435710c.setBackground(r118);
        return;
    L79:
        return;
    L61:
        r118 = r107;
        goto L62
    L47:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_9;
        goto L56
    L48:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_8;
        goto L56
    L49:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_7;
        goto L56
    L50:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_6;
        goto L56
    L51:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_5;
        goto L56
    L52:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_4;
        goto L56
    L53:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_3;
        goto L56
    L54:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_2;
        goto L56
    L55:
        r120 = R.drawable.office_sdk_mm_subtitle_speaker_10;
        goto L56
    L33:
        if (StringsKt.startsWith$default(r116, "-", false, 2, null) != true) goto L35;
        r105 = true;
        goto L36
    L67:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.c.f435199a) == false) goto L71;
        this.f435710c.setVisibility(8);
        this.f435709b.setVisibility(0);
        this.f435709b.setImageResource(a());
        return;
    L71:
        throw new NoWhenBranchMatchedException();
    }

    public MmSubtitleSpeakerAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435708a = new SparseArray();
        LKUIRoundedImageView r103 = new LKUIRoundedImageView(r100);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r103.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r103.setOval(true);
        this.f435709b = r103;
        addView(r103);
        View r104 = LayoutInflater.from(r100).inflate(R.layout.office_sdk_mm_view_scd_avatar, this, false);
        Intrinsics.checkNotNull(r104);
        this.f435710c = r104;
        this.f435711d = (TextView) r104.findViewById(R.id.scdLabel);
        r104.setVisibility(8);
        addView(r104);
    }

    public /* synthetic */ MmSubtitleSpeakerAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
