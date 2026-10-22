package vr1;

import com.bytedance.android.livesdk.chatroom.likeegg.LikeEggSyncDataModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface n {
    Map<String, String> a(com.bytedance.android.livesdk.chatroom.likeegg.a r100, int r101, String r102);

    void c(String r100, String r101, Map<String, String> r102, Function1<? super String, Unit> r103, Function0<Unit> r104);

    void d(DataCenter r100, Function1<? super LikeEggSyncDataModel, Unit> r101);

    void getQrCodeInfo(int r100, String r101, Function1<? super String, Unit> r102);

    void preloadTemplateResource(String r100);
}
