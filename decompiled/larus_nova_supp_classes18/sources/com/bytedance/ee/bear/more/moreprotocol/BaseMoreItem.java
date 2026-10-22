package com.bytedance.ee.bear.more.moreprotocol;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.more.protocol3.b;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.l;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Deprecated(message = "implement class MoreItemV3 instead. ")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0004J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0004J\b\u0010\u0015\u001a\u00020\u0012H\u0004J\b\u0010\u0016\u001a\u00020\u0012H\u0004J\u001d\u0010\u0017\u001a\u00020\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0012H\u0004J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u0004\u0018\u00010\u001dJ\n\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IBaseMoreItem;", "Lcom/bytedance/ee/bear/more/protocol3/MoreItem;", "<init>", "()V", "host", "Lcom/bytedance/ee/bear/more/moreprotocol/IMoreHost;", "setHost", "", "getHost", "onRelease", "getString", "", "resId", "", "getMoreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "isItemDisabledByJSMsg", "", "getItemDisableReasonByJSMsg", "isItemInvisibleByJSMsg", "isItemInvisibleByBenefit", "shouldShowBadgeByJSMsg", "isContainsCurItem", "items", "", "([Ljava/lang/String;)Z", "shouldShowBadgeByBusiness", "hostProvider", "Lcom/bytedance/ee/bear/more/protocol3/MoreProvider;", "init", "create", "release", "notifyItemChanged", "getHostProvider", "buildUI", "Lcom/bytedance/ee/bear/more/protocol3/UIMoreItem;", "JSMsgCheckerForOld", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMoreItem implements IBaseMoreItem, b {
    private sj5.b host;
    private transient h hostProvider;

    public final class a implements m, com.bytedance.ee.bear.more.protocol3.a {
        public final String a;
        public final c b;

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final String b() {
            c r0 = this.b;
            if (r0 == null) goto L8;
            Map<String, String> r1 = r0.M();
            if (r1 == null) goto L8;
            String r2 = r1.get(this.a);
            if (r2 == null) goto L8;
            return r2;
        L8:
            return "";
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final boolean isEnable() {
            c r0 = this.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return !c(r0.B());
        }

        @Override // com.bytedance.ee.bear.more.protocol3.m
        public final boolean isVisible() {
            c r0 = this.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return !c(r0.O());
        }

        public final boolean c(String[] r5) {
            if (r5 != null) goto L5;
        L18:
            return false;
        L5:
            if (r5.length != 0) goto L7;
            boolean r1 = true;
        L9:
            if ((!r1) == false) goto L18;
            if (TextUtils.isEmpty(this.a) == true) goto L18;
            Iterator r6 = ArrayIteratorKt.iterator(r5);
        L14:
            if (r6.hasNext() == false) goto L18;
            if (TextUtils.equals(this.a, (String) r6.next()) == false) goto L14;
            return true;
        L7:
            r1 = false;
            goto L9
        }

        public a(String r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
            this.a = r2;
            this.b = r3;
        }
    }

    public BaseMoreItem() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public void create() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void onRelease() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public k buildUI() {
        h r0 = this.hostProvider;
        if (r0 == null) goto L11;
        a r1 = new a(getId(), getMoreInfo());
        l r2 = r0.b;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiItemFactory");
        r2 = null;
    L9:
        return r2.a(this, r1, r1);
    L11:
        throw new NullPointerException("hostProvider is null. ");
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public sj5.b getHost() {
        h r0 = this.hostProvider;
        if (r0 == null) goto L6;
        sj5.b r1 = r0.f();
        if (r1 == null) goto L6;
        return r1;
    L6:
        sj5.b r2 = this.host;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    L11:
        return r2;
    }

    public final c getMoreInfo() {
        h r0 = this.hostProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getItemDisableReasonByJSMsg() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return null;
    L5:
        Map<String, String> r1 = r0.M();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.get(getId());
    }

    public final boolean isItemDisabledByJSMsg() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return isContainsCurItem(r0.B());
    }

    public final boolean isItemInvisibleByBenefit() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0.K().get(getId()), Boolean.FALSE);
    }

    public final boolean isItemInvisibleByJSMsg() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return isContainsCurItem(r0.O());
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void notifyItemChanged() {
        h r0 = getHostProvider();
        if (r0 == null) goto L6;
        r0.h(getId());
        return;
    }

    public final boolean shouldShowBadgeByBusiness() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (e.g.b != r0.getType()) goto L8;
    L12:
        return false;
    L8:
        if (e.o.b == r0.getType()) goto L12;
        return true;
    }

    public final boolean shouldShowBadgeByJSMsg() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return isContainsCurItem(r0.l());
    }

    public final h getHostProvider() {
        return this.hostProvider;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public void release() {
        onRelease();
    }

    private final boolean isContainsCurItem(String[] r5) {
        if (r5 != null) goto L5;
    L18:
        return false;
    L5:
        if (r5.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == false) goto L18;
        if (TextUtils.isEmpty(getId()) == true) goto L18;
        Iterator r6 = ArrayIteratorKt.iterator(r5);
    L14:
        if (r6.hasNext() == false) goto L18;
        if (TextUtils.equals(getId(), (String) r6.next()) == false) goto L14;
        return true;
    L7:
        r1 = false;
        goto L9
    }

    public final String getString(int r2) {
        if (getHost().getHostFragment().getContext() != null) goto L5;
        tt5.a.k("BaseMoreItem", "getString()...context == null");
        return "";
    L5:
        String r3 = getHost().getHostFragment().getString(r2);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public void init(h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostProvider");
        this.hostProvider = r2;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void setHost(sj5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.host = r2;
    }
}
