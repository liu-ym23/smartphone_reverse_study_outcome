package com.ss.android.lark.officesdk.integrator.im.impl;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.utils.f0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(f0.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/impl/OfficeSdkDeeplinkContextImpl;", "Lcom/ss/android/lark/utils/ILarkDeeplinkContext;", "<init>", "()V", "getSchema", "", "getSupportedSchemes", "", "isSupportedSchema", "", "schema", "isStrict", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSdkDeeplinkContextImpl implements f0 {
    public static final a Companion = null;
    private static final List<String> schemaList = null;

    public static final class a {
        public a() {
        }
    }

    public OfficeSdkDeeplinkContextImpl() {
    }

    static {
        Companion = new a();
        schemaList = CollectionsKt.listOf(new String[]{"http", "https", "lark", "feishu"});
    }

    public String getSchema() {
        return (String) CollectionsKt.first(schemaList);
    }

    @Override // com.ss.android.lark.utils.f0
    public List<String> getSupportedSchemes() {
        return schemaList;
    }

    public boolean isSupportedSchema(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        List<String> r102 = getSupportedSchemes();
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        if (StringsKt.equals((String) r103.next(), r100, !r101) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return false;
    }
}
