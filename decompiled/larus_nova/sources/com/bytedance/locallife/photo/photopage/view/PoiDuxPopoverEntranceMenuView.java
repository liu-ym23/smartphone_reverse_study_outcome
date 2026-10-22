package com.bytedance.locallife.photo.photopage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.dux.popover.menu.DuxPopoverMenuView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiDuxPopoverEntranceMenuView;", "Lcom/bytedance/dux/popover/menu/DuxPopoverMenuView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDuxPopoverEntranceMenuView extends DuxPopoverMenuView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super View, Unit> f262311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<b> f262312k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f262313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<? super View, Unit> f262314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<b> f262315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f262316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f262317e;

        public final Context getContext() {
            return this.f262313a;
        }

        public a(PoiAlbumPageActivity r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f262313a = r100;
            this.f262314b = PoiDuxPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE;
            this.f262315c = new ArrayList();
            this.f262316d = -1;
        }

        public final void a(Integer r100, CharSequence r110, Function1 r111) {
            ArrayList<b> r101 = this.f262315c;
            if (r100 == null) goto L5;
            int r102 = r100.intValue();
        L6:
            r101.add(new b(r102, r110, false, r111, null));
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f262318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f262319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f262320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<? super View, Unit> f262321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f262322e;

        public b(int r100, CharSequence r101, boolean r102, Function1<? super View, Unit> r103, String r104) {
            this.f262318a = r100;
            this.f262319b = r101;
            this.f262320c = r102;
            this.f262321d = r103;
            this.f262322e = r104;
        }
    }

    public PoiDuxPopoverEntranceMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public PoiDuxPopoverEntranceMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public PoiDuxPopoverEntranceMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public PoiDuxPopoverEntranceMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, null);
        this.f262311j = PoiDuxPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        this.f262312k = new ArrayList();
    }
}
