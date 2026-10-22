package ofb;

import com.bytedance.lark.pb.basic.v1.FilePreviewStage;
import com.bytedance.lark.pb.media.v1.BrowseFolderRequest;
import com.bytedance.lark.pb.media.v1.BrowseFolderResponse;
import com.bytedance.lark.pb.media.v1.DownloadFileOptions;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f523136a = null;

    static {
        f523136a = new b();
    }

    public b() {
    }

    public static BrowseFolderRequest.Builder a(nfb.b r100) {
        BrowseFolderRequest.SerReq r101 = new BrowseFolderRequest.SerReq.Builder().key(r100.f518999a).start(Long.valueOf(r100.f519000b)).step(Long.valueOf(r100.f519001c)).order_type(BrowseFolderRequest.SerReq.IndexKey.fromValue(r100.f519002d)).order_direction(BrowseFolderRequest.SerReq.Direction.fromValue(r100.f519003e)).build();
        String r102 = r100.f519005g;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L19;
        String r105 = r100.f519007i;
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        DownloadFileOptions r107 = null;
    L47:
        return new BrowseFolderRequest.Builder().ser_req(r101).scene(DownloadFileScene.fromValue(r100.f519004f)).options(r107);
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
    L19:
        DownloadFileOptions.Builder r108 = new DownloadFileOptions.Builder();
        String r109 = r100.f519005g;
        if (r109 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == true) goto L28;
        r108.preview_token(r100.f519005g);
    L28:
        String r111 = r100.f519006h;
        if (r111 != null) goto L31;
    L34:
        boolean r112 = true;
    L35:
        if (r112 == true) goto L37;
        r108.auth_file_key(r100.f519006h);
    L37:
        String r113 = r100.f519007i;
        if (r113 != null) goto L40;
    L43:
        if (r103 == true) goto L45;
        r108.msg_link_token(r100.f519007i);
    L45:
        r107 = r108.build();
        goto L47
    L40:
        if (r113.length() == 0) goto L43;
        r103 = false;
        goto L43
    L31:
        if (r111.length() == 0) goto L34;
        r112 = false;
        goto L35
    L22:
        if (r109.length() == 0) goto L25;
        r110 = false;
        goto L26
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static nfb.c b(BrowseFolderResponse r110, String r111) {
        if (r110 == null) goto L61;
        List<BrowseFolderResponse.SerResp.BrowseInfo> r100 = r110.ser_resp.infos;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L68;
        List<BrowseFolderResponse.SerResp.BrowseInfo> r102 = r110.ser_resp.infos;
        Map<String, String> r103 = r110.key2path;
        ArrayList r104 = new ArrayList();
        Intrinsics.checkNotNull(r102);
        Iterator<T> r105 = r102.iterator();
    L14:
        if (r105.hasNext() == false) goto L59;
        BrowseFolderResponse.SerResp.BrowseInfo r106 = (BrowseFolderResponse.SerResp.BrowseInfo) r105.next();
        String r107 = r106.key;
        if (r103 == null) goto L19;
        String r108 = r103.get(r107);
        if (r108 == null) goto L19;
    L20:
        Intrinsics.checkNotNull(r106);
        String r109 = r106.key;
        nfb.a.C6924a r112 = new nfb.a.C6924a();
        Intrinsics.checkNotNull(r109);
        Intrinsics.checkNotNullParameter(r109, "key");
        r112.f518987a = r109;
        String r113 = r106.name;
        Intrinsics.checkNotNullParameter(r113, "name");
        r112.f518989c = r113;
        FileType.a r114 = FileType.Companion;
        int r115 = r106.type.getValue();
        r114.getClass();
        FileType[] r116 = FileType.values();
        int r117 = r116.length;
        int r118 = 0;
    L21:
        if (r118 >= r117) goto L26;
        FileType r119 = r116[r118];
        if (r119.getNumber() == r115) goto L27;
        r118 = r118 + 1;
    L27:
        Intrinsics.checkNotNullParameter(r119, "type");
        r112.f518988b = r119;
        r112.f518990d = r106.size.longValue();
        r112.f518991e = r106.create_time.longValue();
        r112.f518992f = r106.owner_id.longValue();
        r112.f518995i = r106.preview_image_key;
        FilePreviewStage r120 = r106.preview_stage;
        if (r120 == null) goto L43;
        com.ss.android.lark.chat.entity.message.content.FilePreviewStage.a r121 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Companion;
        int r122 = r120.getValue();
        r121.getClass();
        if (r122 != 1) goto L32;
        com.ss.android.lark.chat.entity.message.content.FilePreviewStage r123 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Normal;
    L42:
        Intrinsics.checkNotNullParameter(r123, "filePreviewStage");
        r112.f518996j = r123;
        goto L43
    L32:
        if (r122 != 2) goto L34;
        r123 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Encrypted;
        goto L42
    L34:
        if (r122 != 3) goto L36;
        r123 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.NotSupportedType;
        goto L42
    L36:
        if (r122 == 4) goto L38;
        r123 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.UnknownStage;
        goto L42
    L38:
        r123 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.NotSupportedSize;
    L43:
        String r124 = r106.owner_name;
        if (r124 != null) goto L46;
    L49:
        boolean r125 = true;
    L50:
        if (r125 == true) goto L53;
        String r126 = r106.owner_name;
        Intrinsics.checkNotNullParameter(r126, "ownerName");
        r112.f518993g = r126;
    L53:
        if (r108.length() != 0) goto L55;
        boolean r127 = true;
    L56:
        if (r127 == true) goto L58;
        Intrinsics.checkNotNullParameter(r108, "path");
        r112.f518994h = r108;
    L58:
        nfb.a r128 = r112.a();
        r128.f518986l = r111;
        r104.add(r128);
        goto L14
    L55:
        r127 = false;
        goto L56
    L46:
        if (r124.length() == 0) goto L49;
        r125 = false;
        goto L50
    L26:
        r119 = FileType.UNKNOWN;
    L19:
        r108 = "";
        goto L20
    L59:
        nfb.c r129 = new nfb.c();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r129.f519011a = r104;
        r129.f519012b = r110.ser_resp.all_count.longValue();
        r129.f519013c = r110.ser_resp.has_more.booleanValue();
        return r129;
    L68:
        return null;
    L6:
        if (r100.isEmpty() == true) goto L9;
        r101 = false;
        goto L10
    L61:
        return null;
    }
}
