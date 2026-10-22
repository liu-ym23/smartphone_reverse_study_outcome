package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Token f209419c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Token f209420d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Token f209421e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Token f209422f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Token f209423g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Token f209424h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Token f209425i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hr4.a f209426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.location.a f209427b;

    public static final class a {
    }

    public static boolean a(double r100, double r101) {
        if (r100 >= (-90.0d)) goto L5;
    L11:
        return false;
    L5:
        if (r100 > 90.0d) goto L11;
        if (r101 < (-180.0d)) goto L11;
        if (r101 > 180.0d) goto L11;
        return true;
    }

    static {
        f209419c = new Token("LARK-PSDA-bitable_auto_location_cell_request_location_permission");
        f209420d = new Token("LARK-PSDA-bitable_form_auto_location_cell");
        f209421e = new Token("LARK-PSDA-bitable_form_map_location_cell");
        f209422f = new Token("LARK-PSDA-bitable_card_auto_location_cell");
        f209423g = new Token("LARK-PSDA-bitable_card_map_location_cell");
        f209424h = new Token("LARK-PSDA-bitable_form_location_cell_showAddress");
        f209425i = new Token("LARK-PSDA-bitable_card_location_cell_showAddress");
    }

    public e(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.location.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        this.f209426a = r100;
        this.f209427b = r101;
    }
}
