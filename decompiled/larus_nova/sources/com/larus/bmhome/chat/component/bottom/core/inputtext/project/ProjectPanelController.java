package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectFolder;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import t19.s;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class ProjectPanelController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f299108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f299109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f299110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<be8.a> f299111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f299112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f299113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f299114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f299115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f299116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f299117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<b> f299118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f299119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f299120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f299121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ProjectPanelController$backCallback$1 f299122o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final be8.f f299123a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299123a, ((b) r100).f299123a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f299123a.hashCode();
        }

        public final String toString() {
            return "ProjectItem(selection=" + this.f299123a + ')';
        }

        public b(be8.f r100) {
            Intrinsics.checkNotNullParameter(r100, "selection");
            this.f299123a = r100;
        }
    }

    static {
    }

    public final void b() {
        this.f299117j = false;
        setEnabled(false);
        this.f299110c.f299142i.setVisibility(8);
    }

    public final boolean c() {
        if (this.f299112e.invoke().booleanValue() == false) goto L6;
        return true;
    L6:
        s r100 = s.f544207a;
        Context r101 = this.f299115h;
        s.j(r100, r101, r101.getString(R.string.larus_bot_ban_notice_error), null, false, 28);
        return false;
    }

    public final void d() {
        if (this.f299119l == false) goto L6;
        e();
        return;
    L6:
        IProjectListDataSource r100 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r100 != null) goto L10;
        e();
        return;
    L10:
        this.f299119l = true;
        e();
        Job r101 = this.f299121n;
        if (r101 == null) goto L13;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L13:
        this.f299121n = BuildersKt.launch$default(this.f299108a, null, null, new ProjectPanelController$loadProjects$1(r100, this, null), 3, null);
    }

    public final void e() {
        if (this.f299117j == true) goto L5;
        return;
    L5:
        be8.a r100 = this.f299111d.invoke();
        if (r100 == null) goto L8;
        String r101 = r100.Ve();
    L9:
        List<b> r102 = this.f299118k;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L24;
        Object r105 = r104.next();
        b r106 = (b) r105;
        if (this.f299116i.length() != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == false) goto L11;
        r103.add(r105);
        goto L11
    L18:
        if (StringsKt.contains(r106.f299123a.f18774b, this.f299116i, true) == true) goto L21;
        r108 = false;
        goto L22
    L15:
        r107 = false;
        goto L16
    L24:
        List<? extends o> r109 = CollectionsKt.listOf(new o.b(this.f299115h.getString(R.string.larus_input_slash_chosseProject)));
        List r110 = CollectionsKt.createListBuilder();
        Iterator r111 = r103.iterator();
    L26:
        if (r111.hasNext() == false) goto L33;
        final b r112 = (b) r111.next();
        String r113 = r112.f299123a.f18774b;
        Integer r114 = Integer.valueOf(R.drawable.larus_dbx_ic_folder);
        if (Intrinsics.areEqual(r112.f299123a.f18773a, r101) == false) goto L30;
        Integer r115 = Integer.valueOf(v19.c.b(R.attr.larus_ic_check_mark_black, this.f299115h, R.drawable.larus_ic_check_mark_black));
    L31:
        Context r116 = this.f299115h;
        Integer r117 = r115;
        r110.add(new o.d(r113, true, null, 0.0f, null, r114, null, null, r117, Integer.valueOf(ContextCompat.getColor(r116, v19.c.b(R.attr.larus_neutral_100, r116, R.color.larus_neutral_100))), null, null, null, new com.larus.bmhome.chat.component.bottom.core.inputtext.project.a(this, r112), 15580));
        goto L26
    L30:
        r115 = null;
        goto L31
    L33:
        if (this.f299119l == false) goto L38;
        int r118 = 0;
    L36:
        if (r118 >= 5) goto L38;
        r110.add(o.c.f299087a);
        r118 = r118 + 1;
    L38:
        List<? extends o> r119 = CollectionsKt.build(r110);
        List r120 = CollectionsKt.createListBuilder();
        r120.add(new o.d(this.f299115h.getString(R.string.larus_input_projects_createProject), false, null, 0.0f, null, Integer.valueOf(R.drawable.larus_dbx_ic_add), null, null, null, null, null, null, null, new com.larus.bmhome.chat.component.bottom.core.inputtext.project.b(this), 16350));
        if (r101 == null) goto L41;
        r120.add(new o.d(this.f299115h.getString(R.string.larus_local_agent_not_use_project), false, null, 0.0f, null, Integer.valueOf(R.drawable.larus_dbx_ic_cancerfolder), null, null, null, null, null, null, null, new c(this), 16350));
    L41:
        List<? extends o> r121 = CollectionsKt.build(r120);
        h r122 = this.f299110c;
        String r123 = this.f299116i;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r109, "topItems");
        Intrinsics.checkNotNullParameter(r119, "projectItems");
        Intrinsics.checkNotNullParameter(r121, "bottomItems");
        Intrinsics.checkNotNullParameter(r123, "highlightKeyword");
        InputPanelListView r124 = r122.f299134a;
        LinearLayout r125 = r122.f299139f;
        int r126 = InputPanelListView.f299040h;
        r124.e(r125, r109, "");
        r122.f299134a.e(r122.f299138e, r119, r123);
        r122.f299134a.e(r122.f299140g, r121, "");
        InputPanelListView r127 = r122.f299134a;
        List r128 = CollectionsKt.plus(CollectionsKt.plus(r109, r119), r121);
        int r129 = c7.b(16);
        r127.getClass();
        Intrinsics.checkNotNullParameter(r128, "items");
        r122.f299137d = r129 + (r128.size() * r127.f299044d);
        r122.a();
        r122.f299142i.setVisibility(0);
        return;
    L8:
        r101 = null;
        goto L9
    }

    public static final b a(ProjectPanelController r110, OmniProject r111) {
        r110.getClass();
        String r100 = null;
        if (r111.status == OmniProjectStatus.OmniProjectStatus_DELETED) goto L37;
        String r112 = r111.projectId;
        if (r112 != null) goto L8;
        return null;
    L8:
        if ((!StringsKt.isBlank(r112)) == false) goto L10;
        String r101 = r112;
    L11:
        if (r101 == null) goto L38;
        List<OmniProjectFolder> r113 = r111.folders;
        if (r113 != null) goto L16;
        r113 = CollectionsKt.emptyList();
    L16:
        OmniProjectFolder r114 = (OmniProjectFolder) CollectionsKt.firstOrNull(r113);
        String r115 = r111.name;
        if (r115 != null) goto L19;
        r115 = "";
    L19:
        String r102 = r115;
        if (r114 != null) goto L22;
        boolean r103 = true;
    L23:
        if (r114 == null) goto L25;
        String r104 = r114.folderName;
    L26:
        if (r114 == null) goto L28;
        String r105 = r114.workspace;
    L29:
        if (r114 == null) goto L31;
        String r106 = r114.folderDeviceId;
    L32:
        if (r114 == null) goto L35;
        r100 = r114.folderDeviceName;
    L35:
        return new b(new be8.f(r101, r102, r103, r104, r105, r106, r100, 128));
    L31:
        r106 = null;
        goto L32
    L28:
        r105 = null;
        goto L29
    L25:
        r104 = null;
        goto L26
    L22:
        r103 = false;
        goto L23
    L38:
        return null;
    L10:
        r101 = null;
        goto L11
    L37:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.activity.OnBackPressedCallback, com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController$backCallback$1] */
    public ProjectPanelController(CoroutineScope r100, Fragment r101, h r102, Function0<? extends be8.a> r103, Function0<Boolean> r104, Function0<Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        Intrinsics.checkNotNullParameter(r101, "hostFragment");
        Intrinsics.checkNotNullParameter(r102, "panelView");
        Intrinsics.checkNotNullParameter(r103, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r104, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r105, com.alipay.sdk.m.x.d.f25924n);
        Intrinsics.checkNotNullParameter(r106, "onFinished");
        this.f299108a = r100;
        this.f299109b = r101;
        this.f299110c = r102;
        this.f299111d = r103;
        this.f299112e = r104;
        this.f299113f = r105;
        this.f299114g = r106;
        this.f299115h = r101.requireContext();
        this.f299116i = "";
        this.f299118k = CollectionsKt.emptyList();
        this.f299120m = true;
        ?? r107 = new ProjectPanelController$backCallback$1(this);
        this.f299122o = r107;
        Function0<Unit> r108 = new d(this);
        Intrinsics.checkNotNullParameter(r108, "action");
        r102.f299135b = r108;
        r101.requireActivity().getOnBackPressedDispatcher().addCallback(r101, r107);
    }
}
