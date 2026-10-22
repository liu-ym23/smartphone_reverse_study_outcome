package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProData;", "Lcom/bytedance/ee/util/io/NonProguard;", "roleList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lkotlin/collections/ArrayList;", "defaultConfig", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultAccessConfig;", "<init>", "(Ljava/util/ArrayList;Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultAccessConfig;)V", "getRoleList", "()Ljava/util/ArrayList;", "getDefaultConfig", "()Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultAccessConfig;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProData implements NonProguard {
    private final DefaultAccessConfig defaultConfig;
    private final ArrayList<Role> roleList;

    /* JADX WARN: Multi-variable type inference failed */
    public BitableProData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final DefaultAccessConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public final ArrayList<Role> getRoleList() {
        return this.roleList;
    }

    public BitableProData(ArrayList<Role> r1, DefaultAccessConfig r2) {
        this.roleList = r1;
        this.defaultConfig = r2;
    }

    public /* synthetic */ BitableProData(ArrayList r2, DefaultAccessConfig r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
