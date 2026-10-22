package qtb;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface b extends IOfficeSDKProtocol {
    boolean K(String r100);

    void M(com.ss.android.lark.flow.feed.sidebar.human.c r100);

    Object N1(byte[] r100, Continuation<? super byte[]> r101);

    boolean P0();

    boolean X1(String r100, boolean r101, long r102);

    boolean Y1();

    void a0(com.ss.android.lark.flow.feed.sidebar.human.c r100);

    Object g0(byte[] r100, Continuation<? super byte[]> r101);

    boolean getIsImFeatureOpenedByHostManual();

    Object z1(byte[] r100, Continuation<? super Unit> r101);
}
