package com.bytedance.ee.bear.bitable.share.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.DefaultShareMeta;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;
import pu4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u008b\u0001\u00101\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2K\u0010(\u001aG\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110.¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002000)2\u0006\u0010$\u001a\u00020%J\u0010\u00103\u001a\u0002002\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00104\u001a\u0002002\u0006\u0010/\u001a\u00020.H\u0002J\b\u00105\u001a\u000200H\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010(\u001aI\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110.¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/view/BitableShareSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "switchViewFromXml", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getSwitchViewFromXml", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "setSwitchViewFromXml", "(Lcom/larksuite/component/universe_design/udswitch/UDSwitch;)V", "textTvFromXml", "Landroid/widget/TextView;", "getTextTvFromXml", "()Landroid/widget/TextView;", "setTextTvFromXml", "(Landroid/widget/TextView;)V", "textDescFromXml", "getTextDescFromXml", "setTextDescFromXml", "SERVER_PENDING", "token", "", "tableId", "viewId", "recordId", "shareType", "shareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "checkChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "titleTitleDelegate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "tv", "descTv", "", "isChecked", "", "init", "tvDesc", "setMeta", "updateState", "onDetachedFromWindow", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareSwitchView extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public UDSwitch a;
    public TextView b;
    public TextView c;
    public final int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public IShareMeta j;
    public CompoundButton.OnCheckedChangeListener k;
    public final CompositeDisposable l;
    public Function3<? super TextView, ? super TextView, ? super Boolean, Unit> m;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BitableShareSwitchView a;

        public a(BitableShareSwitchView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            boolean r5 = this.a.getSwitchViewFromXml().isChecked();
            int r0 = f.a;
            EShareType r1 = this.a.j.getShareType();
            Intrinsics.checkNotNullParameter(r1, "shareType");
            if (r5 == false) goto L5;
            String r2 = "open";
        L6:
            f.c(r2, "none", r1);
            BitableShareSwitchView.R5(this.a, r5);
            return;
        L5:
            r2 = "close";
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BitableShareSwitchView a;
        public final /* synthetic */ boolean b;

        public c(BitableShareSwitchView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            tt5.a.h("BitableShareSwitchView", "setMeta()...succeed");
            BitableShareSwitchView r0 = this.a;
            boolean r1 = this.b;
            int r2 = BitableShareSwitchView.n;
            r0.getSwitchViewFromXml().setChecked(r1);
            Function3<? super TextView, ? super TextView, ? super Boolean, Unit> r3 = r0.m;
            if (r3 == null) goto L5;
            r3.invoke(r0.getTextTvFromXml(), r0.getTextDescFromXml(), Boolean.valueOf(r1));
        L5:
            this.a.j.setFlag(this.b ? 1 : 0);
            IShareMeta r4 = this.a.j;
            Intrinsics.checkNotNull(r6);
            r4.setShareToken(r6);
            BitableShareSwitchView r7 = this.a;
            CompoundButton.OnCheckedChangeListener r8 = r7.k;
            if (r8 == null) goto L9;
            r8.onCheckedChanged(r7.getSwitchViewFromXml(), this.b);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BitableShareSwitchView a;
        public final /* synthetic */ boolean b;

        public d(BitableShareSwitchView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView] */
        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("BitableShareSwitchView", "setMeta()...error", r5, false);
            if ((r5 instanceof NetService.ServerErrorException) == false) goto L5;
            int r6 = ((NetService.ServerErrorException) r5).getCode();
        L6:
            ?? r0 = this.a;
            if (r6 != r0.d) goto L10;
            int r7 = 2131886372;
        L13:
            UDToast.show(r0.getContext(), r7);
            if (this.b == false) goto L16;
            int r8 = f.a;
            EShareType.a r9 = EShareType.Companion;
            int r1 = this.a.i;
            r9.getClass();
            EShareType r10 = EShareType.a.a(r1);
            Intrinsics.checkNotNullParameter(r10, "shareType");
            f.c("share_failed", "none", r10);
        L16:
            this.a.getSwitchViewFromXml().setChecked(!this.b);
            return;
        L10:
            if (this.b == false) goto L12;
            r7 = 2131886845;
            goto L13
        L12:
            r7 = 2131886844;
            goto L13
        L5:
            r6 = -1;
            goto L6
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UDSwitch getSwitchViewFromXml() {
        UDSwitch r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131387837);
        this.a = r0;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView getTextDescFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388374);
        this.c = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView getTextTvFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388385);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.l.dispose();
    }

    public BitableShareSwitchView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setMeta(boolean r12) {
        this.l.clear();
        String r0 = this.e;
        String r1 = this.f;
        String r2 = this.g;
        int r3 = this.i;
        String r4 = this.h;
        int r5 = pu4.a.a;
        Intrinsics.checkNotNullParameter(r0, "baseToken");
        Intrinsics.checkNotNullParameter(r1, "tableId");
        Intrinsics.checkNotNullParameter(r2, "viewId");
        Intrinsics.checkNotNullParameter(r4, "recordId");
        NetService.f r9 = new NetService.f("/space/api/bitable/share/flag/update");
        r9.c = 1;
        JSONObject r10 = new JSONObject();
        r10.put("baseToken", r0);
        r10.put("tableId", r1);
        r10.put("viewId", r2);
        r10.put("shareType", Integer.valueOf(r3));
        r10.put("flag", Integer.valueOf(r12 ? 1 : 0));
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r10.put("recordId", r4);
    L5:
        r9.j = r10.toJSONString();
        Disposable r13 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new h()).a(r9).map(pu4.d.a).subscribe(new c(this, r12), new d(this, r12));
        this.l.add(r13);
    }

    public final void setSwitchViewFromXml(UDSwitch r1) {
        this.a = r1;
    }

    public final void setTextDescFromXml(TextView r1) {
        this.c = r1;
    }

    public final void setTextTvFromXml(TextView r1) {
        this.b = r1;
    }

    public BitableShareSwitchView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void R5(BitableShareSwitchView r0, boolean r1) {
        r0.setMeta(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitableShareSwitchView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = 800004000;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.j = new DefaultShareMeta();
        this.l = new CompositeDisposable();
        LayoutInflater.from(r2).inflate(2131559000, this);
        getSwitchViewFromXml().setOnClickListener(new a(this));
    }

    public final void S5(String r2, String r3, String r4, String r5, int r6, IShareMeta r7, Function3<? super TextView, ? super TextView, ? super Boolean, Unit> r8, CompoundButton.OnCheckedChangeListener r9) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "tableId");
        Intrinsics.checkNotNullParameter(r4, "viewId");
        Intrinsics.checkNotNullParameter(r5, "recordId");
        Intrinsics.checkNotNullParameter(r7, "shareMeta");
        Intrinsics.checkNotNullParameter(r8, "titleTitleDelegate");
        Intrinsics.checkNotNullParameter(r9, "checkChangeListener");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r9;
        this.m = r8;
        boolean r10 = r7.isOpen();
        getSwitchViewFromXml().setChecked(r10);
        Function3<? super TextView, ? super TextView, ? super Boolean, Unit> r11 = this.m;
        if (r11 == null) goto L6;
        r11.invoke(getTextTvFromXml(), getTextDescFromXml(), Boolean.valueOf(r10));
        return;
    }
}
