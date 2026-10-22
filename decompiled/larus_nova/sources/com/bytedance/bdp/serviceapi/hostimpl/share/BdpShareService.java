package com.bytedance.bdp.serviceapi.hostimpl.share;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.List;
import kotlin.Pair;
import pb4.a;
import pb4.b;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpShareService extends IBdpService {
    void addShareInfo(Pair<String, List<Object>> r100);

    boolean auditShareInfo();

    void clearShareInfo();

    Pair<String, List<Object>> getNextShareInfo();

    boolean isBlockChannelDefault(String r100, boolean r101);

    boolean isSupportPictureToken();

    void openShareDialog(Activity r100, a r101, b r102, boolean r103);

    void openShareDialog(Activity r100, a r101, String[] r102, b r103, boolean r104);

    void registerShareCallback(BdpShareCallback r100);

    boolean share(Activity r100, a r101, BdpShareCallback r102, BdpShareCallback r103);

    boolean solidifyImageWhenImageShare();
}
