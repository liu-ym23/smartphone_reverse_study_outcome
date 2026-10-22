package com.bytedance.ee.lark.infra.network.util;

import com.alipay.sdk.m.u.i;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "entry", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class EcoNetworkLogUtil$Companion$headerAndCookieJoinToEncryptStr$encryptStr$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    final /* synthetic */ Ref.ObjectRef<String> $cookieEncryptStr;

    public EcoNetworkLogUtil$Companion$headerAndCookieJoinToEncryptStr$encryptStr$1(Ref.ObjectRef<String> r100) {
        this.$cookieEncryptStr = r100;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.String] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, String> r210) {
        Intrinsics.checkNotNullParameter(r210, "entry");
        String r100 = r210.getKey();
        String r101 = r210.getValue();
        if (r101 == null) goto L5;
        Set<String> r102 = a.f242810a;
        String r103 = a.C3479a.a(r101);
    L6:
        String r104 = r210.getKey();
        if (r104 == null) goto L9;
        String r105 = r104.toLowerCase(Locale.ROOT);
    L11:
        if (StringsKt.equals$default(r105, BaseHttpRequestInfo.KEY_COOKIE, false, 2, null) == false) goto L30;
        Ref.ObjectRef<String> r106 = this.$cookieEncryptStr;
        StringBuilder r107 = new StringBuilder();
        r107.append(this.$cookieEncryptStr.element);
        Set<String> r108 = a.f242810a;
        String r109 = r210.getValue();
        String r110 = "";
        if (r109 == null) goto L28;
        List r111 = StringsKt.split$default(r109, new String[]{i.f25853b}, false, 0, 6, null);
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L17:
        if (r113.hasNext() == false) goto L19;
        r112.add(StringsKt.trim((String) r113.next()).toString());
        goto L17
    L19:
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r115 = r112.iterator();
    L21:
        if (r115.hasNext() == false) goto L27;
        List r116 = StringsKt.split$default((String) r115.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        String r117 = StringsKt.trim((String) ListProtector.get(r116, 0)).toString();
        if (r116.size() <= 1) goto L25;
        Set<String> r118 = a.f242810a;
        String r119 = a.C3479a.a(StringsKt.trim((String) ListProtector.get(r116, 1)).toString());
    L26:
        r114.add(r117 + " = " + r119);
        goto L21
    L25:
        r119 = "";
        goto L26
    L27:
        r110 = CollectionsKt.joinToString$default(r114, ", ", "{", i.f25855d, 0, null, null, 56, null);
    L28:
        r107.append(r110);
        r106.element = r107.toString();
    L30:
        return r100 + " = " + r103;
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
