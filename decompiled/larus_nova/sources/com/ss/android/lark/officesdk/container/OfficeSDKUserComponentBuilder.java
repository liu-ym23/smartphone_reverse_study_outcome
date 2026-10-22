package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.passportc.entity.UserSession;
import dagger.BindsInstance;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentBuilder;", "", "userSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "build", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OfficeSDKUserComponentBuilder {
    OfficeSDKUserComponent build();

    OfficeSDKUserComponentBuilder userSession(@BindsInstance UserSession r100);
}
