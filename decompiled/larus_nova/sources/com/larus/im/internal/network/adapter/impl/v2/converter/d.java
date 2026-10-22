package com.larus.im.internal.network.adapter.impl.v2.converter;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.network.proto2.AvCmd;
import com.larus.im.internal.network.proto2.AvFile;
import com.larus.im.internal.network.proto2.AvUplink;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import we9.n;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements je9.c<xe9.d, AvUplink.UplinkMessage.Builder> {
    public d() {
    }

    @Override // je9.c
    public final void a(Message.Builder r100, xe9.e r101) {
        AvUplink.UplinkMessage.Builder r102 = (AvUplink.UplinkMessage.Builder) r100;
        xe9.d r103 = (xe9.d) r101;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r103 instanceof n) == false) goto L18;
        n r104 = (n) r103;
        r102.setEvent(AvCmd.AVCMD.FILE_UPLINK);
        AvFile.FileData.Builder r105 = AvFile.FileData.newBuilder();
        r105.setUploadId(r104.f559438a);
        r105.setData(ByteString.copyFrom(r104.f559439b));
        AvFile.ImageBaseInfo.Builder r106 = AvFile.ImageBaseInfo.newBuilder();
        r106.setWidth(r104.f559440c);
        r106.setHeight(r104.f559441d);
        int r107 = r104.f559442e;
        if (r107 != 1) goto L7;
        AvFile.ImageFormat r108 = AvFile.ImageFormat.JPEG;
    L11:
        r106.setFormat(r108);
        r105.setImageBaseInfo(r106.build());
        AvFile.FileBizInfo.Builder r109 = AvFile.FileBizInfo.newBuilder();
        r105.setFileType(AvFile.FileType.IMAGE);
        r109.setBizType(AvFile.FileBizType.DoraImage);
        Map<String, Object> r110 = r104.f559443f;
        if (r110 == null) goto L15;
        String r111 = com.larus.im.internal.utils.n.a(r110).toString();
        if (r111 == null) goto L15;
    L16:
        r109.setBizInfo(r111);
        r105.setFileBizInfo(r109.build());
        AvFile.FileUplinkBody.Builder r112 = AvFile.FileUplinkBody.newBuilder();
        r112.addUploadFiles(r105.build());
        AvUplink.UplinkBody.Builder r113 = AvUplink.UplinkBody.newBuilder();
        r113.setFileBody(r112.build());
        r102.setUplinkBody(r113.build());
        return;
    L15:
        r111 = "";
        goto L16
    L7:
        if (r107 == 2) goto L9;
        r108 = AvFile.ImageFormat.UNRECOGNIZED;
        goto L11
    L9:
        r108 = AvFile.ImageFormat.HEIF;
        goto L11
    L18:
        if ((r103 instanceof we9.e) == false) goto L22;
        we9.e r114 = (we9.e) r103;
        r102.setEvent(AvCmd.AVCMD.FILE_UPLINK);
        AvFile.FileData.Builder r115 = AvFile.FileData.newBuilder();
        r115.setFileType(AvFile.FileType.OCR_META);
        AvFile.OcrInfo.Builder r116 = AvFile.OcrInfo.newBuilder();
        r116.setHasOcrText(r114.f559420a);
        r116.setOcrText(r114.f559421b);
        r116.setTimestamp(r114.f559422c);
        r115.setOcrInfo(r116.build());
        AvFile.FileUplinkBody.Builder r117 = AvFile.FileUplinkBody.newBuilder();
        r117.addUploadFiles(r115.build());
        AvUplink.UplinkBody.Builder r118 = AvUplink.UplinkBody.newBuilder();
        r118.setFileBody(r117.build());
        r102.setUplinkBody(r118.build());
        return;
    }
}
