package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar;", "getTopAvatar", "getUnderAvatar", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarGroupSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OAvatarGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OAvatar f398761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OAvatar f398762b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f398763a = null;

        static {
            int[] r100 = new int[OAvatar.AvatarSize.values().length];
            r100[OAvatar.AvatarSize.DP_24.ordinal()] = 1;
            r100[OAvatar.AvatarSize.DP_32.ordinal()] = 2;
            r100[OAvatar.AvatarSize.DP_40.ordinal()] = 3;
            r100[OAvatar.AvatarSize.DP_48.ordinal()] = 4;
            r100[OAvatar.AvatarSize.DP_56.ordinal()] = 5;
            r100[OAvatar.AvatarSize.DP_64.ordinal()] = 6;
            r100[OAvatar.AvatarSize.DP_72.ordinal()] = 7;
            f398763a = r100;
        }
    }

    public final OAvatar getTopAvatar() {
        return this.f398762b;
    }

    public final OAvatar getUnderAvatar() {
        return this.f398761a;
    }

    public OAvatarGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAvatarGroupSize(OAvatar.AvatarSize r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        switch(a.f398763a[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.AvatarSize r101 = OAvatar.AvatarSize.DP_48;
    L14:
        if (r100.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L16;
        int r102 = 3;
    L17:
        int r103 = d.n(this, r102);
        R5(this.f398762b, r101, r103);
        R5(this.f398761a, r101, r103);
        ViewGroup.LayoutParams r104 = getLayoutParams();
        if (r104 == null) goto L22;
        r104.height = d.n(this, r100.getDpValue());
        r104.width = d.n(this, r100.getDpValue());
        setLayoutParams(r104);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        r102 = 2;
        goto L17
    L7:
        r101 = OAvatar.AvatarSize.DP_40;
        goto L14
    L8:
        r101 = OAvatar.AvatarSize.DP_40;
        goto L14
    L9:
        r101 = OAvatar.AvatarSize.DP_32;
        goto L14
    L10:
        r101 = OAvatar.AvatarSize.DP_24;
        goto L14
    L11:
        r101 = OAvatar.AvatarSize.DP_20;
        goto L14
    L12:
        r101 = OAvatar.AvatarSize.DP_16;
        goto L14
    L5:
        throw new IllegalArgumentException(Intrinsics.stringPlus("disallow the size: ", r100));
    }

    public OAvatarGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_widget_avatar_group, this);
        this.f398761a = (OAvatar) findViewById(R.id.under_avatar);
        this.f398762b = (OAvatar) findViewById(R.id.top_avatar);
    }

    public final void R5(OAvatar r100, OAvatar.AvatarSize r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L7;
        int r104 = r102 * 2;
        r103.width = d.n(this, r101.getDpValue()) + r104;
        r103.height = r104 + d.n(this, r101.getDpValue());
        r100.setLayoutParams(r103);
        r100.setAvatarInset(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
