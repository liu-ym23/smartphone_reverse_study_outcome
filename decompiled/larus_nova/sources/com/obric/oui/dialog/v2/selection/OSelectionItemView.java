package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Landroid/view/View;", "getCheckMark", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "", "checked", "setChecked", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSelectionItemView extends ODialogListItemView {

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "", UserProfileEvent.POSITION_NONE, "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
        public static final enum CheckStyle extends Enum<CheckStyle> {
            public static final CheckStyle CHECKBOX = null;
            public static final CheckStyle ICON = null;
            public static final CheckStyle NONE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ CheckStyle[] f400791a = null;

            public static CheckStyle valueOf(String r100) {
                return (CheckStyle) r27.a.a(CheckStyle.class, r100);
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) f400791a.clone();
            }

            static {
                CheckStyle r100 = new CheckStyle(UserProfileEvent.POSITION_NONE, 0);
                NONE = r100;
                CheckStyle r101 = new CheckStyle("ICON", 1);
                ICON = r101;
                CheckStyle r102 = new CheckStyle("CHECKBOX", 2);
                CHECKBOX = r102;
                f400791a = new CheckStyle[]{r100, r101, r102};
            }

            public CheckStyle(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400792a = null;

        static {
            int[] r100 = new int[Companion.CheckStyle.values().length];
            r100[Companion.CheckStyle.ICON.ordinal()] = 1;
            r100[Companion.CheckStyle.CHECKBOX.ordinal()] = 2;
            r100[Companion.CheckStyle.NONE.ordinal()] = 3;
            f400792a = r100;
        }
    }

    static {
    }

    private final View getCheckMark() {
        int r100 = vma.c.f556351a;
        View r101 = getTrailingContainer().getChildAt(0);
        if (r101 != null) goto L6;
    L4:
        r101 = null;
    L7:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getChildAt(0);
    L6:
        if ((r101 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    public final void setCheckStyle(Companion.CheckStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = a.f400792a[r100.ordinal()];
        ImageView r102 = null;
        if (r101 != 1) goto L5;
        ImageView r103 = new ImageView(getContext());
        r103.setImageDrawable(ResourcesCompat.getDrawable(r103.getContext().getResources(), R.drawable.oui_select_list_item_checker, null));
        r102 = r103;
    L13:
        if (r102 == null) goto L15;
        FrameLayout r104 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        r104.addView(r102, r105);
        ViewGroup.LayoutParams r106 = new ViewGroup.LayoutParams(d.n(this, 32), -2);
        Intrinsics.checkNotNullParameter(r104, "view");
        Intrinsics.checkNotNullParameter(r106, "layoutParams");
        d(getTrailingContainer(), r104, r106);
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = new OCheckBox(getContext());
        goto L13
    L7:
        if (r101 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r100) {
        View r101 = getCheckMark();
        if ((r101 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r101).setChecked(r100);
        return;
    L6:
        if ((r101 instanceof ImageView) == false) goto L12;
        ImageView r102 = (ImageView) r101;
        if (r100 == false) goto L10;
        int r103 = 0;
    L11:
        r102.setVisibility(r103);
        return;
    L10:
        r103 = 4;
        goto L11
    L12:
        wma.b.a("OSelectionItemView", "checkMark is not OCheckBox or ImageView");
    }

    public OSelectionItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(Companion.CheckStyle.NONE);
        this.f400779m = true;
        getLeadingContainer().measure(0, 0);
        OneShotPreDrawListener.add(this, new com.obric.oui.dialog.v2.common.a(this, this, true));
    }
}
