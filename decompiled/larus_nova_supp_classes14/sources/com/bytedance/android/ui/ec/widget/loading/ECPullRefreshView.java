package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "refreshTextConfig", "Lcom/bytedance/android/ui/ec/widget/loading/RefreshTextConfig;", "statusTextView", "Landroid/widget/TextView;", "initLayoutParams", "", "initViews", "setRefreshState", "targetState", "Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$RefreshState;", "setRefreshTextConfig", "Companion", "RefreshState", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPullRefreshView extends LinearLayout {
    public static final Companion Companion = null;
    private static final float LOAD_REFRESH_TEXT_SIZE = 12.0f;
    private RefreshTextConfig refreshTextConfig;
    private TextView statusTextView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$Companion;", "", "()V", "LOAD_REFRESH_TEXT_SIZE", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$RefreshState;", "", "(Ljava/lang/String;I)V", "PULL", "REFRESHING", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RefreshState extends Enum<RefreshState> {
        private static final /* synthetic */ RefreshState[] $VALUES = null;
        public static final RefreshState PULL = null;
        public static final RefreshState REFRESHING = null;

        static {
            RefreshState r1 = new RefreshState("PULL", 0);
            PULL = r1;
            RefreshState r2 = new RefreshState("REFRESHING", 1);
            REFRESHING = r2;
            $VALUES = new RefreshState[]{r1, r2};
        }

        public static RefreshState valueOf(String r1) {
            return (RefreshState) a.a(RefreshState.class, r1);
        }

        public static RefreshState[] values() {
            return (RefreshState[]) $VALUES.clone();
        }

        private RefreshState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[RefreshState.PULL.ordinal()] = 1;
            r0[RefreshState.REFRESHING.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECPullRefreshView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECPullRefreshView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    private final void initViews() {
        addView(new ECDuxLoadingAnimationView(getContext(), null, 0, 6, null));
        TextView r0 = new TextView(getContext());
        r0.setTextSize(1, LOAD_REFRESH_TEXT_SIZE);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131101736));
        Unit r1 = Unit.INSTANCE;
        this.statusTextView = r0;
        addView(r0);
        setRefreshState(RefreshState.REFRESHING);
    }

    private final void initLayoutParams() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = -2;
        r0.height = -2;
        setLayoutParams(r0);
    L5:
        setOrientation(0);
    }

    public final void setRefreshState(RefreshState r3) {
        Intrinsics.checkNotNullParameter(r3, "targetState");
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 != 1) goto L5;
        TextView r5 = this.statusTextView;
        if (r5 == null) goto L22;
        CharSequence r0 = this.refreshTextConfig.getPullText();
        if (r0 != null) goto L18;
        r0 = getContext().getString(2131896708);
    L18:
        r5.setText(r0);
        return;
    L22:
        return;
    L5:
        if (r4 != 2) goto L23;
        TextView r6 = this.statusTextView;
        if (r6 == null) goto L20;
        CharSequence r1 = this.refreshTextConfig.getLoadingText();
        if (r1 != null) goto L12;
        r1 = getContext().getString(2131896537);
    L12:
        r6.setText(r1);
        return;
    L20:
        return;
    }

    public final void setRefreshTextConfig(RefreshTextConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "refreshTextConfig");
        this.refreshTextConfig = r2;
    }

    public ECPullRefreshView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.refreshTextConfig = new RefreshTextConfig(null, null, 3, null);
        initLayoutParams();
        setGravity(17);
        initViews();
    }

    public /* synthetic */ ECPullRefreshView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
