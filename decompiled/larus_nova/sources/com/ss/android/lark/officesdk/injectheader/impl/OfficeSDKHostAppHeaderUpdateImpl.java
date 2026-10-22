package com.ss.android.lark.officesdk.injectheader.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.NetDecorator;
import com.bytedance.lark.pb.tool.v1.SetCustomParamsRequest;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKGlobalScope
public final class OfficeSDKHostAppHeaderUpdateImpl implements utb.a {

    public static final class a {
    }

    public static final class b<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f433258a = null;

        static {
            f433258a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            return null;
        }
    }

    static {
    }

    @Inject
    public OfficeSDKHostAppHeaderUpdateImpl() {
    }

    @Override // utb.a
    public final void G3(List<HostUriParamGroup> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Log.i("OfficeSDKHeaderUpdate", "updateHeader called: count=" + ((ArrayList) r100).size());
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        HostUriParamGroup r102 = (HostUriParamGroup) r101.next();
        Set<String> r103 = r102.getUris();
        if (r103 == null) goto L11;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Log.d("OfficeSDKHeaderUpdate", "HostApp header update uri: " + ((String) r104.next()));
    L11:
        Iterator<Map.Entry<String, String>> r105 = r102.getParams().entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L4;
        Log.d("OfficeSDKHeaderUpdate", "HostApp header update param: " + r105.next());
        goto L13
    L15:
        final ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r107 = r100.iterator();
    L17:
        if (r107.hasNext() == false) goto L24;
        HostUriParamGroup r108 = (HostUriParamGroup) r107.next();
        Set<String> r109 = r108.getUris();
        if (r109 == null) goto L22;
        List<String> r110 = CollectionsKt.toList(r109);
        if (r110 == null) goto L22;
    L23:
        r106.add(new NetDecorator.Builder().urls(r110).headers(r108.getParams()).build());
    L22:
        r110 = CollectionsKt.emptyList();
        goto L23
    L24:
        SdkSender.asynSendRequestNonWrap(Command.SET_CUSTOM_PARAMS, new SetCustomParamsRequest.Builder().net_decorators(r106), new OfficeSDKHostAppHeaderUpdateImpl$updateHeader$2(r106), b.f433258a);
    }
}
