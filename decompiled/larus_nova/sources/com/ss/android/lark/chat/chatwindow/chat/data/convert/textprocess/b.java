package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess;

import android.text.Layout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.processor.c0;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public boolean A;
    public MessagePermissionUtil.ReceiveAuthorizationState B;
    public ValidateIMFileResult C;
    public boolean D;
    public boolean E;
    public final boolean F;
    public InterfaceC4800b G;
    public HashMap<String, HashMap<Integer, Layout>> H;
    public HashMap<String, HashMap<Integer, Layout>> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f412401J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public c0.b S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public PrefixSpanStyle Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f412402a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f412403a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f412404b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f412405b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f412406c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f412407c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f412408d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f412409d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f412410e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f412411e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f412412f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f412413f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f412414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f412415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f412416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f412417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f412418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f412419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f412420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValidateResult f412421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f412422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f412423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f412424q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f412425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f412426s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f412427t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f412428u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Layout.Alignment f412429v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f412430w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f412431x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f412432y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CodeBlockV2ProcessParams f412433z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b$b, reason: collision with other inner class name */
    public interface InterfaceC4800b {
        Integer a();
    }

    static {
    }

    public b() {
        this.f412402a = new ArrayList();
        this.f412404b = new ArrayList();
        this.f412419l = "";
        this.f412420m = true;
        this.f412421n = new ValidateResult(ResultType.ALLOW);
        this.f412422o = true;
        this.f412423p = "";
        this.f412424q = "";
        this.f412428u = -1;
        this.f412429v = Layout.Alignment.ALIGN_NORMAL;
        this.f412431x = 17;
        this.f412432y = -1;
        this.B = MessagePermissionUtil.ReceiveAuthorizationState.NORMAL_STATE;
        this.D = true;
        this.E = true;
        this.F = true;
        this.H = new HashMap();
        this.I = new HashMap();
        this.f412401J = true;
        this.K = true;
        this.Q = -1;
        this.R = -1;
        this.T = -1;
        this.U = 1;
        this.X = UIHelper.dp2px(5.0f);
        this.Y = PrefixSpanStyle.NORMAL;
    }

    public final void a(ValidateResult r100) {
        Intrinsics.checkNotNullParameter(r100, "previewValidateResult");
        this.f412421n = r100;
    }
}
