package com.bytedance.push.interfaze;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Pair;
import com.bytedance.push.third.d;
import com.ss.android.push.Triple;
import java.io.IOException;
import java.util.Set;
import java.util.zip.DataFormatException;
import org.json.JSONObject;
import yfc.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IThirdSupportService {
    public static final String KEY_PUSH_TOKEN_SENT = "push_token_sent";
    public static final String LOG_TYPE = "ss_push";
    public static final String SEND_PUSH_TOKEN_URL = null;

    boolean allowPullUp(String r100);

    boolean canKeepPackageAlive(Context r100, String r101);

    String getAdmPayloadName();

    String getFcmPayloadName();

    JSONObject getMessage(byte[] r100, boolean r101) throws DataFormatException, IOException;

    String getMessageV2(int r100, byte[] r101, boolean r102) throws DataFormatException, IOException;

    Pair<String, String> getPushConfig(int r100);

    String getToken(Context r100, int r101);

    Triple<String, String, String> getUmConfig();

    void hackJobHandler(Service r100);

    boolean isMainProcess(Context r100);

    void onClickNotPassThroughNotification(Context r100, String r101, int r102, String r103);

    void registerSenderFailed(int r100, String r101, String r102);

    void registerSenderSuccessAndUploadToken(Context r100, int r101, String r102);

    void sendMonitor(Context r100, String r101, JSONObject r102);

    void sendToken(Context r100, d r101);

    boolean shouldShowUpgradeDialog(Activity r100);

    static {
        Set<Integer> r100 = yfc.d.f567458a;
        SEND_PUSH_TOKEN_URL = a.a("/service/1/update_token/");
    }
}
