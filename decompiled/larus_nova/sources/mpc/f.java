package mpc;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface f extends IOfficeSDKCapacity {
    void B(List<byte[]> r100);

    void cc(ForwardScene r100, g r101, boolean r102);

    boolean g1(Context r100, npc.a r101, List r102, String r103, u48.c r104);

    void g8(Context r100, ImageView r101, String r102, String r103, int r104, int r105);

    void gf(Context r100, ForwardDoubaoContent r101, List r102, u48.b r103);

    boolean i1(Context r100, npc.a r101);

    void o8(Context r100, npc.d r101);
}
