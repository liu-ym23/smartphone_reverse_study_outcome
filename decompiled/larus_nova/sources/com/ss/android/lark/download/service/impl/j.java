package com.ss.android.lark.download.service.impl;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.text.TextUtils;
import com.bytedance.lark.pb.media.v1.DownloadFileOptions;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.compliance.CanUserDownloadRiskFileRequest;
import com.ss.android.lark.pb.compliance.CanUserDownloadRiskFileResponse;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements wbb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f420559a;

    public class a implements SdkSender.IParser<Boolean> {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Boolean parse(byte[] r100) throws IOException {
            return CanUserDownloadRiskFileResponse.ADAPTER.decode(r100).mcan_download;
        }
    }

    public j() {
        this.f420559a = e.b.f420544a;
    }

    public final void c(IGetDataCallback<Boolean> r100) {
        Log.i("DownloadFile", "canUserDownloadRiskFile calls.");
        CanUserDownloadRiskFileRequest.Builder r101 = new CanUserDownloadRiskFileRequest.Builder().op_usage(CanUserDownloadRiskFileRequest.FileOperateUsage.Download).source_terminal(CanUserDownloadRiskFileRequest.SourceTerminal.Mobile);
        SdkSender.sendPassThroughRequest(Command.CAN_USER_DOWNLOAD_FILE, r101, r100, new a());
    }

    public static void a(Context r100, String r101, Token r102) {
        Log.i("DownloadFile", "notifySystemScanFile, filePath = " + r101);
        if (r102 != null) goto L14;
        FileUtils.u(r100, r101);
    L9:
        String[] r103 = FileUtils.f285888a;
        if (TextUtils.isEmpty(r101) == true) goto L16;
        MediaScannerConnection.scanFile(r100, new String[]{r101}, new String[]{FileUtils.p(r101)}, new n());
        return;
    L16:
        return;
    L14:
        FileUtils.v(r100, r101, r102);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w("DownloadFile", "notifySystemScanFilePsda failed", e);
        goto L9
    }

    public static DownloadFileOptions b(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        return null;
    L14:
        DownloadFileOptions.Builder r104 = new DownloadFileOptions.Builder();
        if (TextUtils.isEmpty(r100) == true) goto L18;
        r104.preview_token(r100);
    L18:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        r104.auth_file_key(r101);
    L21:
        if (TextUtils.isEmpty(null) == true) goto L24;
        r104.watermark_scene(null);
    L24:
        if (TextUtils.isEmpty(r102) == true) goto L27;
        r104.msg_link_token(r102);
    L27:
        return r104.build();
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        if (TextUtils.isEmpty(null) == false) goto L11;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r103 = true;
        goto L12
    }
}
