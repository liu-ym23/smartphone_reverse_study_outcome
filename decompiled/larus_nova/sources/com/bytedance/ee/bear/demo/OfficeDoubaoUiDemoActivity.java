package com.bytedance.ee.bear.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadFileType;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadStatus;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadUiController;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.Keys;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001c\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J*\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u001c\u0010\"\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J*\u0010#\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0012\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\fH\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\b\u00107\u001a\u000208H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeDoubaoUiDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "screenMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenu;", "uploadUiController", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadUiController;", "uploadDemoRound", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "showDemoMenu", "anchor", "Landroid/view/View;", "showListLongPressMenu", "showMoreListMenu", "parentMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", TplType.MENU, "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuItem;", "showPlusMenu", "showPlusSortMenu", "buildDemoMenuItems", "", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItem;", "buildListLongPressMenu", "clickListener", "Lkotlin/Function1;", "buildMoreListMenu", "items", "buildPlusMenu", "buildPlusSortMenu", "buildListLongPressMenuItems", "buildMoreListMenuItems", "buildPlusMenuItems", "buildPlusSortMenuItems", "createPlusMenuDivider", "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuDivider;", "widthDp", "showUploadDemo", "buildDemoUploadItems", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItem;", "round", Keys.API_PARAM_KEY_MB, "", "value", "", "kb", "measureMenuWidth", "menuView", "dp", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDoubaoUiDemoActivity extends Hilt_OfficeDoubaoUiDemoActivity implements d0c.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f217518g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.office.common.screenmenu.j f217519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeUploadUiController f217520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f217521f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDoubaoUiDemoActivity f217522a;

        public b(OfficeDoubaoUiDemoActivity r100) {
            this.f217522a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r810) {
            final OfficeDoubaoUiDemoActivity r100 = this.f217522a;
            Intrinsics.checkNotNull(r810);
            r100.f217519d.n(OfficeDoubaoUiDemoActivity$showDemoMenu$1.INSTANCE);
            CommonMenu r101 = new CommonMenu(r100);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r101);
            int r410 = View.generateViewId();
            Integer r210 = Integer.valueOf(R.drawable.office_ic_screen_menu_export_file);
            r101.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "分享", null, null, Integer.valueOf(R.drawable.office_ic_screen_menu_share), true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "下载", null, null, Integer.valueOf(R.drawable.office_ic_drive_item_menu_download), true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(r410, "多选", null, null, r210, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, r100.C1(8), r100.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "重命名", null, null, Integer.valueOf(R.drawable.office_ic_drive_item_menu_rename), true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "移动到", null, null, r210, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "删除", null, Integer.valueOf(ColorProtector.parseColor("#F54A45")), Integer.valueOf(R.drawable.office_ic_drive_item_menu_delete), true, false, null, false, null, false, false, null, null, 65476)}), new OfficeDoubaoUiDemoActivity$showDemoMenu$menu$1(r100));
            r100.f217519d.s(r810, r101.j(), com.bytedance.ee.bear.office.common.screenmenu.u.f235254d);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDoubaoUiDemoActivity f217523a;

        public c(OfficeDoubaoUiDemoActivity r100) {
            this.f217523a = r100;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [T, com.bytedance.ee.bear.office.common.screenmenu.CommonMenu] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r113) {
            final OfficeDoubaoUiDemoActivity r100 = this.f217523a;
            Intrinsics.checkNotNull(r113);
            r100.f217519d.n(OfficeDoubaoUiDemoActivity$showListLongPressMenu$1.INSTANCE);
            final Ref.ObjectRef r101 = new Ref.ObjectRef();
            Function1<fk5.a, Unit> r102 = new OfficeDoubaoUiDemoActivity$showListLongPressMenu$2(r100, r101);
            ?? r103 = new CommonMenu(r100);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r103);
            r103.d(r100.C1(240));
            r103.f235157f = 0;
            int r210 = View.generateViewId();
            Integer r110 = Integer.valueOf(R.drawable.office_ic_screen_menu_copy);
            Integer r211 = Integer.valueOf(R.drawable.office_ic_screen_menu_more);
            Integer r810 = Integer.valueOf(R.drawable.office_ic_screen_menu_arrow_up);
            int r510 = View.generateViewId();
            Integer r910 = Integer.valueOf(R.drawable.office_ic_screen_menu_export_file);
            r103.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "问问豆包", null, null, Integer.valueOf(R.drawable.office_ic_drive_item_menu_ask_ai), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, r100.C1(8), r100.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "分享", null, null, Integer.valueOf(R.drawable.office_ic_screen_menu_share), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "下载", null, null, Integer.valueOf(R.drawable.office_ic_drive_item_menu_download), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "收藏", null, null, Integer.valueOf(R.drawable.office_ic_screen_menu_collect), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(r210, "复制链接", null, null, r110, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, r100.C1(8), r100.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(1001, "更多", null, null, r211, false, false, r810, false, CollectionsKt.toMutableList(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(1001, "更多", null, null, r211, false, false, r810, false, null, false, false, null, null, 65388), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, r100.C1(8), r100.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(r510, "移动到", null, null, r910, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "添加快捷方式", null, null, r110, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "密级设置", null, null, r910, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "删除", null, Integer.valueOf(ColorProtector.parseColor("#F54A45")), Integer.valueOf(R.drawable.office_ic_drive_item_menu_delete), false, false, null, false, null, false, false, null, null, 65508)})), false, false, null, null, 64364)}), r102);
            r101.element = r103;
            r100.f217519d.s(r113, r103.j(), com.bytedance.ee.bear.office.common.screenmenu.u.f235254d);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDoubaoUiDemoActivity f217524a;

        public d(OfficeDoubaoUiDemoActivity r100) {
            this.f217524a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.bytedance.ee.bear.office.common.screenmenu.CommonMenu] */
        @Override // android.view.View.OnClickListener
        public final void onClick(final View r151) {
            final OfficeDoubaoUiDemoActivity r100 = this.f217524a;
            Intrinsics.checkNotNull(r151);
            int r101 = OfficeDoubaoUiDemoActivity.f217518g;
            r100.getClass();
            final Ref.ObjectRef r102 = new Ref.ObjectRef();
            Function1<fk5.a, Unit> r103 = new OfficeDoubaoUiDemoActivity$showPlusMenu$1(r100, r102);
            ?? r104 = new CommonMenu(r100);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r104);
            r104.d(r100.C1(200));
            r104.f235157f = 0;
            int r810 = View.generateViewId();
            Integer r148 = Integer.valueOf(R.drawable.dbx_ic_check);
            Integer r210 = Integer.valueOf(R.drawable.dbx_ic_change_vertical);
            r104.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建文档", null, null, Integer.valueOf(R.drawable.dbx_ic_filetype_write_ai_line), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建 PPT", null, null, Integer.valueOf(R.drawable.dbx_ic_filetype_pptx_line), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建文件夹", null, null, Integer.valueOf(R.drawable.dbx_ic_folder), false, false, null, false, null, false, false, null, null, 65516), r100.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "上传图片", null, null, Integer.valueOf(R.drawable.dbx_ic_image), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "上传文件", null, null, Integer.valueOf(R.drawable.dbx_ic_file_upload), false, false, null, false, null, false, false, null, null, 65516), r100.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(r810, "选择", null, null, r148, false, false, null, false, null, false, false, null, null, 65516), r100.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "列表视图", null, null, Integer.valueOf(R.drawable.dbx_ic_disorde_list), false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "宫格视图", null, null, Integer.valueOf(R.drawable.dbx_ic_gridview3), false, false, r148, false, null, false, false, null, null, 65388), r100.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(2001, "排序方式", "日期 · 最新到最旧", null, r210, false, false, Integer.valueOf(R.drawable.office_ic_plus_menu_arrow_down), false, CollectionsKt.toMutableList(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(2001, "排序方式", "修改时间 · 最新的排最前", null, r210, false, false, Integer.valueOf(R.drawable.office_ic_plus_menu_arrow_up), false, null, false, false, null, null, 65384), r100.B1(240), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "访问时间", null, null, null, false, true, r148, false, null, false, false, null, null, 65340), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "修改时间", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "名称", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "种类", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "大小", null, null, null, false, true, null, false, null, false, false, null, null, 65468), r100.B1(240), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "最新的排最前", null, null, null, false, true, r148, false, null, false, false, null, null, 65340), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "最旧的排最前", null, null, null, false, true, null, false, null, false, false, null, null, 65468)})), false, false, null, null, 64360)}), r103);
            r102.element = r104;
            r100.f217519d.n(new OfficeDoubaoUiDemoActivity$showPlusMenu$2(r151, r100));
            com.bytedance.ee.bear.office.common.screenmenu.j r105 = r100.f217519d;
            T r106 = r102.element;
            if (r106 != 0) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
            CommonMenu r107 = null;
        L6:
            r105.s(r151, r107.j(), com.bytedance.ee.bear.office.common.screenmenu.u.f235254d);
            return;
        L5:
            r107 = (CommonMenu) r106;
            goto L6
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDoubaoUiDemoActivity f217525a;

        public e(OfficeDoubaoUiDemoActivity r100) {
            this.f217525a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            OfficeDoubaoUiDemoActivity r100 = this.f217525a;
            int r101 = (r100.f217521f + 1) % 3;
            r100.f217521f = r101;
            OfficeUploadUiController r102 = r100.f217520e;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r101 == 1) goto L9;
            if (r101 == 2) goto L8;
            OfficeUploadFileType r110 = OfficeUploadFileType.PDF;
            OfficeUploadStatus r103 = OfficeUploadStatus.FINISH;
            List<com.bytedance.ee.bear.office.common.upload.u> r104 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", r110, r103, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f))), new com.bytedance.ee.bear.office.common.upload.u("upload_doc", "项目方案.docx", OfficeUploadFileType.DOC, r103, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f))), new com.bytedance.ee.bear.office.common.upload.u("upload_sheet", "数据表.xlsx", OfficeUploadFileType.SHEET, r103, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.6f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.6f)))});
        L10:
            r102.b(r104);
            return;
        L8:
            long r105 = (long) (1024 * 900.0f);
            r104 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", OfficeUploadFileType.PDF, OfficeUploadStatus.FAILED, "上传失败", Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(2.2f))), new com.bytedance.ee.bear.office.common.upload.u("upload_image", "会议图片.png", OfficeUploadFileType.IMAGE, OfficeUploadStatus.FINISH, Long.valueOf(r105), Long.valueOf(r105))});
            goto L10
        L9:
            long r106 = (long) (1024 * 900.0f);
            r104 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", OfficeUploadFileType.PDF, OfficeUploadStatus.UPLOADING, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(2.2f))), new com.bytedance.ee.bear.office.common.upload.u("upload_doc", "项目方案.docx", OfficeUploadFileType.DOC, OfficeUploadStatus.UNSTARTED, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f)), 0L), new com.bytedance.ee.bear.office.common.upload.u("upload_image", "会议图片.png", OfficeUploadFileType.IMAGE, OfficeUploadStatus.FAILED, "上传失败", Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.2f)), 0L), new com.bytedance.ee.bear.office.common.upload.u("upload_sheet", "数据表.xlsx", OfficeUploadFileType.SHEET, OfficeUploadStatus.FINISH, Long.valueOf(r106), Long.valueOf(r106))});
            goto L10
        }
    }

    static {
    }

    public static long D1(float r100) {
        float r101 = 1024;
        return (long) ((r100 * r101) * r101);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeDoubaoUiDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OfficeDoubaoUiDemoActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeDoubaoUiDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeDoubaoUiDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public OfficeDoubaoUiDemoActivity() {
        this.f217519d = new com.bytedance.ee.bear.office.common.screenmenu.j();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c B1(int r100) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, C1(8), C1(r100), 74);
    }

    public final int C1(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        A1(r100);
        super.onCreate(r100);
        setContentView(R.layout.activity_office_doubao_ui_demo);
        this.f217519d.h(this);
        OfficeUploadUiController r101 = new OfficeUploadUiController((ViewGroup) findViewById(R.id.office_doubao_ui_demo_root), new com.bytedance.ee.bear.office.common.upload.j0(), 0);
        OfficeUploadUiController.a(r101);
        this.f217520e = r101;
        ((Button) findViewById(R.id.office_doubao_ui_demo_menu_button)).setOnClickListener(new b(this));
        ((Button) findViewById(R.id.office_doubao_ui_demo_list_menu_button)).setOnClickListener(new c(this));
        ((Button) findViewById(R.id.office_doubao_ui_demo_plus_menu_button)).setOnClickListener(new d(this));
        ((Button) findViewById(R.id.office_doubao_ui_demo_upload_button)).setOnClickListener(new e(this));
    }
}
