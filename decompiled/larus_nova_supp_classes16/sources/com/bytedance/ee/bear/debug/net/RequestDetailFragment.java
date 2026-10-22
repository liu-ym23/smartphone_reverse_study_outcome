package com.bytedance.ee.bear.debug.net;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qx4.f;
import qx4.g;
import qx4.h;
import qx4.i;
import qx4.j;
import qx4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0003J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/debug/net/RequestDetailFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "request", "Lcom/bytedance/ee/bear/contract/DebugRequest;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTitleBar", "root", "initUrl", "initRequestHeader", "initResponseHeader", "initResponse", "getFormatResponse", "", "getHeaderValueString", "list", "", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestDetailFragment extends BaseFragment {
    public static final /* synthetic */ int f = 0;
    public DebugRequest e;

    public static final class a {
    }

    static {
    }

    public RequestDetailFragment() {
        this.e = new DebugRequest(0);
    }

    public static String U90(List r3) {
        Iterator r4 = r3.iterator();
        String r0 = "";
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((String) r4.next()) + ';';
        goto L4
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        DebugRequest r4 = (DebugRequest) r3.getParcelable("extra_request");
        if (r4 == null) goto L6;
    L7:
        this.e = r4;
        return;
    L6:
        r4 = new DebugRequest(0);
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        r11.findViewById(2131388775).setLeftClickListener(new k(this));
        r11.findViewById(2131388775).setTitle("请求详情");
        ((TextView) r11.findViewById(2131391945)).setText("URL:" + this.e.b);
        ((LinearLayout) r11.findViewById(2131384383)).setVisibility(8);
        ((TextView) r11.findViewById(2131384384)).setVisibility(8);
        ((LinearLayout) r11.findViewById(2131384383)).setOnClickListener(new f(r11));
        Iterator r13 = MapsKt.toList(this.e.d).iterator();
        int r1 = 0;
        String r3 = "";
        int r4 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        Object r5 = r13.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Pair r6 = (Pair) r5;
        r3 = r3 + ((String) r6.getFirst()) + ':' + U90((List) r6.getSecond());
        if (r4 == (MapsKt.toList(this.e.d).size() - 1)) goto L11;
        r3 = r3 + '\n';
    L11:
        r4 = r8;
        goto L4
    L12:
        ((TextView) r11.findViewById(2131384384)).setText(r3);
        ((LinearLayout) r11.findViewById(2131384434)).setOnClickListener(new i(r11));
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = "";
        Iterator r0 = MapsKt.toList(this.e.f).iterator();
    L14:
        if (r0.hasNext() == false) goto L22;
        Object r2 = r0.next();
        int r7 = r1 + 1;
        if (r1 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        Pair r9 = (Pair) r2;
        r14.element = ((String) r14.element) + ((String) r9.getFirst()) + ':' + U90((List) r9.getSecond());
        if (r1 == (MapsKt.toList(this.e.d).size() - 1)) goto L21;
        r14.element = ((String) r14.element) + '\n';
    L21:
        r1 = r7;
        goto L14
    L22:
        ((TextView) r11.findViewById(2131384435)).setText((CharSequence) r14.element);
        ((TextView) r11.findViewById(2131384435)).setOnLongClickListener(new j(r14, this));
        ((LinearLayout) r11.findViewById(2131384431)).setOnClickListener(new g(r11));
        TextView r10 = (TextView) r11.findViewById(2131384432);
        String r16 = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(this.e.g).getAsJsonObject());     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L25
    L26:
        r10.setText(r16);
        ((TextView) r11.findViewById(2131384432)).setOnLongClickListener(new h(r11, this));
        return;
    L25:
        r16 = this.e.g;
        goto L26
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561240, r3, false);
    }
}
