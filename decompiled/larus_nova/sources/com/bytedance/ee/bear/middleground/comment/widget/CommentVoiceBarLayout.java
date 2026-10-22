package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J0\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "voiceRecordTouchBounds", "Landroid/graphics/Rect;", "voiceRecordView", "Landroid/view/View;", "getVoiceRecordView", "()Landroid/view/View;", "voiceRecordView$delegate", "Lkotlin/Lazy;", "setUiMode", "", "mode", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout$UiMode;", "toggleIconConfig", "Lcom/bytedance/ee/bear/config/CommentVoiceToggleIconConfig;", "setToggleIconConfig", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "updateVoiceRecordTouchBounds", "applyAsideMode", "UiMode", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentVoiceBarLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f232303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f232304b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout$UiMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ASIDE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UiMode extends Enum<UiMode> {
        public static final UiMode ASIDE = null;
        public static final UiMode NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UiMode[] f232305a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f232306b = null;

        public static EnumEntries<UiMode> getEntries() {
            return f232306b;
        }

        static {
            UiMode r100 = new UiMode(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            UiMode r101 = new UiMode("ASIDE", 1);
            ASIDE = r101;
            UiMode[] r102 = {r100, r101};
            f232305a = r102;
            f232306b = EnumEntriesKt.enumEntries(r102);
        }

        public static UiMode[] values() {
            return (UiMode[]) f232305a.clone();
        }

        public static UiMode valueOf(String r100) {
            return (UiMode) r27.a.a(UiMode.class, r100);
        }

        public UiMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public CommentVoiceBarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentVoiceBarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final View getVoiceRecordView() {
        return (View) this.f232304b.getValue();
    }

    public final void setToggleIconConfig(ew4.g r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.f474551a;
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L7:
        AppCompatImageView r103 = (AppCompatImageView) findViewById(R.id.switch_im_keyboard);
        if (r103 == null) goto L11;
        r103.setImageResource(r102);
        return;
    L11:
        return;
    L6:
        r102 = R.drawable.ud_icon_menu_display_outlined;
        goto L7
    }

    public CommentVoiceBarLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f232303a = new Rect();
        this.f232304b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CommentVoiceBarLayout$voiceRecordView$2(this));
    }

    public /* synthetic */ CommentVoiceBarLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        View r105 = getVoiceRecordView();
        if (r105 != null) goto L5;
    L8:
        setTouchDelegate(null);
        return;
    L5:
        if (r105.getVisibility() != 0) goto L8;
        r105.getHitRect(this.f232303a);
        Rect r106 = this.f232303a;
        r106.top = 0;
        r106.bottom = getHeight();
        setTouchDelegate(new TouchDelegate(this.f232303a, r105));
    }
}
