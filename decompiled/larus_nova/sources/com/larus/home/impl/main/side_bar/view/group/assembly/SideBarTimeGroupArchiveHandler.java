package com.larus.home.impl.main.side_bar.view.group.assembly;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common_ui.dialog.p0;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.render.s0;
import com.larus.im.bean.conversation.ArchiveStatus;
import com.larus.im.internal.jni.bean.ArchiveTimeSortBy;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.p3;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarTimeGroupArchiveHandler implements eb9.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f345151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f345152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.common_ui.dialog.j f345153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f345154d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345156a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f345157b = null;

        static {
            int[] r100 = new int[GroupSortPolicy.values().length];
            r100[GroupSortPolicy.CreateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[GroupSortPolicy.UpdateTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[GroupSortPolicy.PinTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f345156a = r100;
            int[] r101 = new int[ArchiveStatus.values().length];
            r101[ArchiveStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[ArchiveStatus.PARTIAL_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[ArchiveStatus.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f345157b = r101;
        }
    }

    public static final class c implements p0 {
        public c() {
        }

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SideBarTimeGroupArchiveHandler f345158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.larus.home.impl.main.side_bar.view.group.render.l f345159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f345160c;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            SideBarTimeGroupArchiveHandler r100 = this.f345158a;
            com.larus.home.impl.main.side_bar.view.group.render.l r101 = this.f345159b;
            String r102 = this.f345160c;
            if (r100.f345154d == true) goto L21;
            s0 r103 = r101.f345678e;
            if (r103 == null) goto L22;
            GroupSortPolicy r104 = r101.f345679f;
            int r105 = b.f345156a[r104.ordinal()];
            if (r105 != 1) goto L11;
            ArchiveTimeSortBy r106 = ArchiveTimeSortBy.ARCHIVE_TIME_SORT_BY_CREATE_TIME;
        L19:
            ArchiveTimeSortBy r110 = r106;
            r100.f345154d = true;
            p3.c(r100.f345152b.invoke(), "chat", null, "time_group", 188);
            com.larus.im.service.r.a.e(com.larus.im.d.d(), null, null, true, r110, r103.f345709a, r103.f345710b, new a0(r100, r102), 3);
            return;
        L11:
            if (r105 != 2) goto L13;
            r106 = ArchiveTimeSortBy.ARCHIVE_TIME_SORT_BY_POSITION_VERSION;
            goto L19
        L13:
            if (r105 != 3) goto L16;
            return;
        L16:
            throw new NoWhenBranchMatchedException();
        L22:
            return;
        }

        public d(SideBarTimeGroupArchiveHandler r100, com.larus.home.impl.main.side_bar.view.group.render.l r101, String r102) {
            this.f345158a = r100;
            this.f345159b = r101;
            this.f345160c = r102;
        }
    }

    static {
    }

    public SideBarTimeGroupArchiveHandler(Fragment r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "currentPageProvider");
        this.f345151a = r100;
        this.f345152b = r101;
        r100.getViewLifecycleOwner().getLifecycle().addObserver(new AnonymousClass1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.q
    public final void a(eb9.o<?> r210, eb9.c r211) {
        Intrinsics.checkNotNullParameter(r210, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r211, "event");
        DATA r100 = r210.f471909c;
        if ((r100 instanceof com.larus.home.impl.main.side_bar.view.group.render.l) == false) goto L5;
        com.larus.home.impl.main.side_bar.view.group.render.l r101 = (com.larus.home.impl.main.side_bar.view.group.render.l) r100;
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.f345678e != null) goto L11;
        return;
    L11:
        if (this.f345154d == true) goto L44;
        com.larus.common_ui.dialog.j r102 = this.f345153c;
        if (r102 != null) goto L15;
    L17:
        boolean r103 = false;
    L18:
        if (r103 == true) goto L47;
        Context r104 = this.f345151a.getContext();
        if (r104 != null) goto L23;
        return;
    L23:
        FragmentActivity r105 = this.f345151a.getActivity();
        if (r105 != null) goto L27;
        return;
    L27:
        if (r105.isFinishing() == false) goto L29;
        return;
    L29:
        if (r105.isDestroyed() == false) goto L31;
        return;
    L31:
        if (this.f345151a.getView() == null) goto L48;
        String r106 = r101.f345675b.a(r104).toString();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r107 = r104.getString(R.string.larus_infra_archiveChat_dialogTitle_archiveTimeGroupChats, new Object[]{r106});
        Intrinsics.checkNotNullParameter(r107, "title");
        String r108 = r104.getString(R.string.larus_infra_archiveChat_confirmDialog_desc_allTimeGroup, new Object[]{r106});
        Intrinsics.checkNotNullParameter(r108, "message");
        c r110 = new c();
        String r109 = r104.getString(R.string.larus_button_cancel);
        Intrinsics.checkNotNullParameter(r110, "listener");
        Intrinsics.checkNotNullParameter(r109, "text");
        Integer r111 = Integer.valueOf(ContextCompat.getColor(r104, v19.c.b(R.attr.larus_primary_50, r104, R.color.larus_primary_50)));
        d r112 = new d(this, r101, r106);
        String r113 = r104.getString(R.string.larus_infra_archiveChat_dialogButton_archiveAll);
        Intrinsics.checkNotNullParameter(r112, "listener");
        Intrinsics.checkNotNullParameter(r113, "text");
        com.larus.common_ui.dialog.j r114 = new com.larus.common_ui.dialog.j(r104, new com.larus.common_ui.dialog.j.b(r107, r108, null, r109, null, r111, true, r110, r113, Integer.valueOf(ContextCompat.getColor(r104, v19.c.b(R.attr.larus_danger_50, r104, R.color.larus_danger_50))), false, r112, false, null, null, null, 0.2f));
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r114);
    L38:
        this.f345153c = r114;
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L37:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L38
    L48:
        return;
    L47:
        return;
    L15:
        if (r102.isShowing() != true) goto L17;
        r103 = true;
        goto L18
    L44:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
