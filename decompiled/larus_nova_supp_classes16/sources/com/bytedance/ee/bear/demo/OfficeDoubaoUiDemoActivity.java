package com.bytedance.ee.bear.demo;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadFileType;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadStatus;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadUiController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001c\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J*\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u001c\u0010\"\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J*\u0010#\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0012\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\fH\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\b\u00107\u001a\u000208H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeDoubaoUiDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "screenMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenu;", "uploadUiController", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadUiController;", "uploadDemoRound", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showDemoMenu", "anchor", "Landroid/view/View;", "showListLongPressMenu", "showMoreListMenu", "parentMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", "menu", "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuItem;", "showPlusMenu", "showPlusSortMenu", "buildDemoMenuItems", "", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItem;", "buildListLongPressMenu", "clickListener", "Lkotlin/Function1;", "buildMoreListMenu", "items", "buildPlusMenu", "buildPlusSortMenu", "buildListLongPressMenuItems", "buildMoreListMenuItems", "buildPlusMenuItems", "buildPlusSortMenuItems", "createPlusMenuDivider", "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuDivider;", "widthDp", "showUploadDemo", "buildDemoUploadItems", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItem;", "round", "mb", "", "value", "", "kb", "measureMenuWidth", "menuView", "dp", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDoubaoUiDemoActivity extends Hilt_OfficeDoubaoUiDemoActivity implements d0c.c {
    public static final /* synthetic */ int g = 0;
    public final com.bytedance.ee.bear.office.common.screenmenu.j d;
    public OfficeUploadUiController e;
    public int f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OfficeDoubaoUiDemoActivity a;

        public b(OfficeDoubaoUiDemoActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.bytedance.ee.bear.demo.OfficeDoubaoUiDemoActivity] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r86) {
            final ?? r1 = this.a;
            Intrinsics.checkNotNull(r86);
            r1.d.n(OfficeDoubaoUiDemoActivity$showDemoMenu$1.INSTANCE);
            CommonMenu r2 = new CommonMenu(r1);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r2);
            r2.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "分享", null, null, 2131244684, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "下载", null, null, 2131244673, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "多选", null, null, 2131244682, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, r1.C1(8), r1.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "重命名", null, null, 2131244674, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "移动到", null, null, 2131244682, true, false, null, false, null, false, false, null, null, 65484), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "删除", null, Integer.valueOf(ColorProtector.parseColor("#F54A45")), 2131244672, true, false, null, false, null, false, false, null, null, 65476)}), new OfficeDoubaoUiDemoActivity$showDemoMenu$menu$1(r1));
            r1.d.s(r86, r2.j(), com.bytedance.ee.bear.office.common.screenmenu.u.d);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OfficeDoubaoUiDemoActivity a;

        public c(OfficeDoubaoUiDemoActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.bytedance.ee.bear.demo.OfficeDoubaoUiDemoActivity] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r113) {
            final ?? r1 = this.a;
            Intrinsics.checkNotNull(r113);
            r1.d.n(OfficeDoubaoUiDemoActivity$showListLongPressMenu$1.INSTANCE);
            final Ref.ObjectRef r2 = new Ref.ObjectRef();
            Function1<fk5.a, Unit> r3 = new OfficeDoubaoUiDemoActivity$showListLongPressMenu$2(r1, r2);
            CommonMenu r4 = new CommonMenu(r1);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r4);
            r4.d(r1.C1(240));
            r4.f = 0;
            r4.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "问问豆包", null, null, 2131244671, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, r1.C1(8), r1.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "分享", null, null, 2131244684, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "下载", null, null, 2131244673, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "收藏", null, null, 2131244680, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "复制链接", null, null, 2131244681, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, r1.C1(8), r1.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(PreviewStatus.UNEXPECTED_COMPRESS_FORMAT, "更多", null, null, 2131244683, false, false, 2131244679, false, CollectionsKt.toMutableList(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(PreviewStatus.UNEXPECTED_COMPRESS_FORMAT, "更多", null, null, 2131244683, false, false, 2131244679, false, null, false, false, null, null, 65388), new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, r1.C1(8), r1.C1(240), 74), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "移动到", null, null, 2131244682, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "添加快捷方式", null, null, 2131244681, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "密级设置", null, null, 2131244682, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "删除", null, Integer.valueOf(ColorProtector.parseColor("#F54A45")), 2131244672, false, false, null, false, null, false, false, null, null, 65508)})), false, false, null, null, 64364)}), r3);
            r2.element = r4;
            r1.d.s(r113, r4.j(), com.bytedance.ee.bear.office.common.screenmenu.u.d);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ OfficeDoubaoUiDemoActivity a;

        public d(OfficeDoubaoUiDemoActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context, com.bytedance.ee.bear.demo.OfficeDoubaoUiDemoActivity, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(final View r151) {
            final ?? r2 = this.a;
            Intrinsics.checkNotNull(r151);
            int r3 = OfficeDoubaoUiDemoActivity.g;
            r2.getClass();
            final Ref.ObjectRef r4 = new Ref.ObjectRef();
            Function1<fk5.a, Unit> r5 = new OfficeDoubaoUiDemoActivity$showPlusMenu$1(r2, r4);
            CommonMenu r6 = new CommonMenu(r2);
            com.bytedance.ee.bear.office.common.screenmenu.b.a(r6);
            r6.d(r2.C1(200));
            r6.f = 0;
            r6.f(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建文档", null, null, 2131233748, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建 PPT", null, null, 2131233747, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "新建文件夹", null, null, 2131233751, false, false, null, false, null, false, false, null, null, 65516), r2.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "上传图片", null, null, 2131233754, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "上传文件", null, null, 2131233745, false, false, null, false, null, false, false, null, null, 65516), r2.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "选择", null, null, 2131233736, false, false, null, false, null, false, false, null, null, 65516), r2.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "列表视图", null, null, 2131233740, false, false, null, false, null, false, false, null, null, 65516), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "宫格视图", null, null, 2131233753, false, false, 2131233736, false, null, false, false, null, null, 65388), r2.B1(200), new com.bytedance.ee.bear.office.common.screenmenu.e(ImportResult.STATUS_SHEET_UPLOAD_WARNING_CELL_CUT, "排序方式", "日期 · 最新到最旧", null, 2131233735, false, false, 2131244677, false, CollectionsKt.toMutableList(CollectionsKt.listOf(new fk5.a[]{new com.bytedance.ee.bear.office.common.screenmenu.e(ImportResult.STATUS_SHEET_UPLOAD_WARNING_CELL_CUT, "排序方式", "修改时间 · 最新的排最前", null, 2131233735, false, false, 2131244678, false, null, false, false, null, null, 65384), r2.B1(240), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "访问时间", null, null, null, false, true, 2131233736, false, null, false, false, null, null, 65340), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "修改时间", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "名称", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "种类", null, null, null, false, true, null, false, null, false, false, null, null, 65468), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "大小", null, null, null, false, true, null, false, null, false, false, null, null, 65468), r2.B1(240), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "最新的排最前", null, null, null, false, true, 2131233736, false, null, false, false, null, null, 65340), new com.bytedance.ee.bear.office.common.screenmenu.e(View.generateViewId(), "最旧的排最前", null, null, null, false, true, null, false, null, false, false, null, null, 65468)})), false, false, null, null, 64360)}), r5);
            r4.element = r6;
            r2.d.n(new OfficeDoubaoUiDemoActivity$showPlusMenu$2(r151, r2));
            com.bytedance.ee.bear.office.common.screenmenu.j r7 = r2.d;
            Object r8 = r4.element;
            if (r8 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
            CommonMenu r9 = null;
        L6:
            r7.s(r151, r9.j(), com.bytedance.ee.bear.office.common.screenmenu.u.d);
            return;
        L5:
            r9 = (CommonMenu) r8;
            goto L6
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ OfficeDoubaoUiDemoActivity a;

        public e(OfficeDoubaoUiDemoActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r28) {
            OfficeDoubaoUiDemoActivity r1 = this.a;
            int r2 = (r1.f + 1) % 3;
            r1.f = r2;
            OfficeUploadUiController r3 = r1.e;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r2 == 1) goto L9;
            if (r2 == 2) goto L8;
            OfficeUploadFileType r16 = OfficeUploadFileType.PDF;
            OfficeUploadStatus r4 = OfficeUploadStatus.FINISH;
            List r5 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", r16, r4, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f))), new com.bytedance.ee.bear.office.common.upload.u("upload_doc", "项目方案.docx", OfficeUploadFileType.DOC, r4, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f))), new com.bytedance.ee.bear.office.common.upload.u("upload_sheet", "数据表.xlsx", OfficeUploadFileType.SHEET, r4, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.6f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.6f)))});
        L10:
            r3.b(r5);
            return;
        L8:
            long r6 = (long) (1024 * 900.0f);
            r5 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", OfficeUploadFileType.PDF, OfficeUploadStatus.FAILED, "上传失败", Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(2.2f))), new com.bytedance.ee.bear.office.common.upload.u("upload_image", "会议图片.png", OfficeUploadFileType.IMAGE, OfficeUploadStatus.FINISH, Long.valueOf(r6), Long.valueOf(r6))});
            goto L10
        L9:
            long r7 = (long) (1024 * 900.0f);
            r5 = CollectionsKt.listOf(new com.bytedance.ee.bear.office.common.upload.u[]{new com.bytedance.ee.bear.office.common.upload.u("upload_pdf", "合同-2025-12.pdf", OfficeUploadFileType.PDF, OfficeUploadStatus.UPLOADING, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(5.8f)), Long.valueOf(OfficeDoubaoUiDemoActivity.D1(2.2f))), new com.bytedance.ee.bear.office.common.upload.u("upload_doc", "项目方案.docx", OfficeUploadFileType.DOC, OfficeUploadStatus.UNSTARTED, Long.valueOf(OfficeDoubaoUiDemoActivity.D1(3.1f)), 0L), new com.bytedance.ee.bear.office.common.upload.u("upload_image", "会议图片.png", OfficeUploadFileType.IMAGE, OfficeUploadStatus.FAILED, "上传失败", Long.valueOf(OfficeDoubaoUiDemoActivity.D1(1.2f)), 0L), new com.bytedance.ee.bear.office.common.upload.u("upload_sheet", "数据表.xlsx", OfficeUploadFileType.SHEET, OfficeUploadStatus.FINISH, Long.valueOf(r7), Long.valueOf(r7))});
            goto L10
        }
    }

    static {
    }

    public static long D1(float r2) {
        float r0 = 1024;
        return (long) ((r2 * r0) * r0);
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeDoubaoUiDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeDoubaoUiDemoActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeDoubaoUiDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeDoubaoUiDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public OfficeDoubaoUiDemoActivity() {
        this.d = new com.bytedance.ee.bear.office.common.screenmenu.j();
    }

    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m127provideComponent() {
        return provideComponent();
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c B1(int r8) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, C1(8), C1(r8), 74);
    }

    public final int C1(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        A1(r4);
        super.onCreate(r4);
        setContentView(2131558498);
        this.d.h(this);
        OfficeUploadUiController r5 = new OfficeUploadUiController((ViewGroup) findViewById(2131381340), new com.bytedance.ee.bear.office.common.upload.j0(), 0);
        OfficeUploadUiController.a(r5);
        this.e = r5;
        ((Button) findViewById(2131381338)).setOnClickListener(new b(this));
        ((Button) findViewById(2131381337)).setOnClickListener(new c(this));
        ((Button) findViewById(2131381339)).setOnClickListener(new d(this));
        ((Button) findViewById(2131381341)).setOnClickListener(new e(this));
    }
}
