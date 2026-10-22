package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements wnb.b<h> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f428459d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f428460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f428462c;

    public static final class a implements wnb.b.a<h> {
        public a() {
        }
    }

    static {
        f428459d = new a();
    }

    @Override // wnb.b
    public final /* synthetic */ boolean i() {
        return false;
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        AttributeSet r100 = null;
        DoubaoMentionPanelView r101 = new DoubaoMentionPanelView(this.f428460a, r100, 6, 0);
        r101.setId(R.id.view_id_keyboard_mention_panel_view);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r101;
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, 0, 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428462c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    public final Context getContext() {
        return this.f428460a;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerTop;
    }

    @Override // wnb.b
    public final wnb.b.a<h> getKey() {
        return f428459d;
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f428460a = r100;
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428462c = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428461b = r100;
    }
}
