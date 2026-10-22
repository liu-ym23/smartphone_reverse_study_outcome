package com.ss.android.lark.officesdk;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.lark.abtest.api.IABTestService;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(IABTestService.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fH\u0016J5\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/MockABTestService;", "Lcom/ss/android/lark/abtest/api/IABTestService;", "<init>", "()V", "registerExperiments", "", "bizName", "", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "Lcom/ss/android/lark/abtest/api/experiment/LarkExperimentConfig;", "getAllAbTestKeys", "", "getAbTestValue", ExifInterface.GPS_DIRECTION_TRUE, "", "configClass", "Ljava/lang/Class;", "withExposure", "", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MockABTestService implements IABTestService {
    public MockABTestService() {
    }

    @Override // com.ss.android.lark.abtest.api.IABTestService
    public void registerExperiments(String r100, List<? extends iua.a<?>> r101) {
    }

    @Override // com.ss.android.lark.abtest.api.IABTestService
    public Set<String> getAllAbTestKeys() {
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.abtest.api.IABTestService
    public <T> T getAbTestValue(Class<? extends iua.a<?>> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "configClass");
        return (T) r100.newInstance().getDefault();
    }
}
