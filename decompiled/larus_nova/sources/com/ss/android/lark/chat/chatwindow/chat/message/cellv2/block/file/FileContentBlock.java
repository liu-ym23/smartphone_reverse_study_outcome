package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b3b.h;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FileContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<FileContentVO>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413129g;

    public static final class a {
    }

    public static final class b implements k<View>, g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileView f413131b;

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void b() {
            this.f413131b.f460891l.setVisibility(8);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void c() {
            this.f413131b.getFileIconView().setCornerRadiusDP(0.0f);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public Context getContext() {
            return this.f413130a.getContext();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void i() {
            FileView r100 = this.f413131b;
            ((ConstraintLayout.LayoutParams) r100.f460894o.getLayoutParams()).guideBegin = 0;
            ((ConstraintLayout.LayoutParams) r100.f460880a.getLayoutParams()).guideBegin = 0;
            ((ConstraintLayout.LayoutParams) r100.f460881b.getLayoutParams()).guideEnd = 0;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void k() {
            this.f413131b.R5();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final ViewGroup o() {
            return this.f413131b.f460891l;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void showLoading() {
            LKUIToast.showLoading(this.f413130a.getContext(), R.string.Lark_Legacy_BaseUiLoading);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void f() {
            this.f413131b.setBackgroundResource(R.drawable.file_message_cell_bg);
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413130a;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void l() {
            LKUIToast.cancelLoading();
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413130a = r100;
            FileView r101 = (FileView) r100.findViewById(R.id.chat_file);
            this.f413131b = r101;
            r101.S5();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void a(int r100) {
            this.f413131b.setTopBorderColor(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void d(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f413131b.f460891l.setLayoutParams(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void e(Object r100) {
            this.f413131b.setTag(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void g(boolean r100) {
            this.f413131b.setFileSizeVisibility(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void h(boolean r100) {
            this.f413131b.setBottomMargin(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void j(boolean r100) {
            this.f413131b.setTopBorderVisibility(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void m(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.c r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f413131b.setOnLongClickListener(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void showToast(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            LKUIToast.show(this.f413130a.getContext(), r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void n(FileView.b r100, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.b r101) {
            Intrinsics.checkNotNullParameter(r100, "fileInfo");
            Intrinsics.checkNotNullParameter(r101, "callback");
            FileView r102 = this.f413131b;
            r102.setCallback(r101);
            r102.setInfo(r100);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f413129g;
    }

    public FileContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413129g = IMMessageKeys$Blocks.FILE_CONTENT;
    }

    public void update(m<y6b.a<FileContentVO>> r100, q<y6b.a<FileContentVO>> r101, y6b.a<FileContentVO> r110) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r110, "data");
        b r102 = (b) r101.c(this.f413129g, IMMessageKeys$Slots.CONTENT, FileContentBlock$update$blockView$1.INSTANCE);
        com.ss.android.lark.blueprint.g r103 = this.f412671a;
        b3b.f r104 = this.f412674d;
        if ((r104 instanceof h) == true) goto L6;
        r104 = null;
    L6:
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a(r103, r104).update(r102, r110, this.f412673c, this.f412675e, r100, this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
