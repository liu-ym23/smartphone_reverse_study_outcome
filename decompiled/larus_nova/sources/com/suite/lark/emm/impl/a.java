package com.suite.lark.emm.impl;

import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.EntryPointAccessors;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Singleton
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f460436a = 0;

    /* JADX INFO: renamed from: com.suite.lark.emm.impl.a$a, reason: collision with other inner class name */
    public static final class C5524a {
        public static a a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).m();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/suite/lark/emm/impl/EnterpriseMobilityManagementModule$EnterpriseMobilityManagementModuleEntryPoint;", "", "getEnterpriseMobilityManagementModule", "Lcom/suite/lark/emm/impl/EnterpriseMobilityManagementModule;", "enterprise-mobility-management-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        a m();
    }

    static {
    }

    @Inject
    public a() {
    }
}
