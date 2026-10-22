package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class DocumentCreateInfoAdapter extends Result<InnerData> {

    public static class InnerData implements NonProguard {
        boolean is_share_folder;
        String obj_token;
        int obj_type;
        String obj_url;
        int owner_type;
        String spaceId;
        String template_token;
        String title;
        String token;
        int type;

        public InnerData() {
        }

        public String getObjToken() {
            return this.obj_token;
        }

        public int getObjType() {
            return this.obj_type;
        }

        public String getObjUrl() {
            return this.obj_url;
        }

        public int getOwnerType() {
            return this.owner_type;
        }

        public String getSpaceId() {
            return this.spaceId;
        }

        public String getTemplateToken() {
            return this.template_token;
        }

        public String getTitle() {
            return this.title;
        }

        public String getToken() {
            return this.token;
        }

        public int getType() {
            return this.type;
        }

        public boolean isShareFolder() {
            return this.is_share_folder;
        }

        public void setObjToken(String r100) {
            this.obj_token = r100;
        }

        public void setObjType(int r100) {
            this.obj_type = r100;
        }

        public void setObjUrl(String r100) {
            this.obj_url = r100;
        }

        public void setOwnerType(int r100) {
            this.owner_type = r100;
        }

        public void setShareFolder(boolean r100) {
            this.is_share_folder = r100;
        }

        public void setSpaceId(String r100) {
            this.spaceId = r100;
        }

        public void setTemplateToken(String r100) {
            this.template_token = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }
    }

    public DocumentCreateInfoAdapter() {
    }

    public DocumentCreateEntity toDocumentCreateInfo(boolean r100) {
        DocumentCreateEntity r101 = new DocumentCreateEntity();
        r101.code = this.code;
        r101.msg = this.msg;
        DATA r102 = this.data;
        String r103 = "";
        if (r102 != 0) goto L5;
        String r104 = "";
    L6:
        r101.token = r104;
        if (r102 != 0) goto L9;
        String r105 = "";
    L10:
        r101.objToken = r105;
        if (r102 != 0) goto L13;
        String r106 = "";
    L14:
        r101.templateToken = r106;
        if (r102 != 0) goto L17;
        String r107 = "";
    L18:
        r101.title = r107;
        if (r102 != 0) goto L21;
        String r108 = "";
    L22:
        r101.url = r108;
        boolean r109 = false;
        if (r102 != 0) goto L25;
        int r110 = 0;
    L26:
        r101.ownerType = r110;
        if (r102 != 0) goto L29;
        boolean r111 = false;
    L30:
        r101.isShareFolder = r111;
        if (r102 != 0) goto L33;
        int r112 = 0;
    L36:
        r101.type = r112;
        if (r102 != 0) goto L39;
        int r113 = 0;
    L40:
        r101.objType = r113;
        if (r102 != 0) goto L44;
    L46:
        r101.isWiki = r109;
        if (r102 == 0) goto L50;
        r103 = ((InnerData) r102).spaceId;
    L50:
        r101.spaceId = r103;
        return r101;
    L44:
        if (sbb.e.f541303n.f541317b != ((InnerData) r102).type) goto L46;
        r109 = true;
        goto L46
    L39:
        r113 = ((InnerData) r102).obj_type;
        goto L40
    L33:
        if (r100 == false) goto L35;
        r112 = ((InnerData) r102).obj_type;
        goto L36
    L35:
        r112 = ((InnerData) r102).type;
        goto L36
    L29:
        r111 = ((InnerData) r102).is_share_folder;
        goto L30
    L25:
        r110 = ((InnerData) r102).owner_type;
        goto L26
    L21:
        r108 = ((InnerData) r102).obj_url;
        goto L22
    L17:
        r107 = ((InnerData) r102).title;
        goto L18
    L13:
        r106 = ((InnerData) r102).template_token;
        goto L14
    L9:
        r105 = ((InnerData) r102).obj_token;
        goto L10
    L5:
        r104 = ((InnerData) r102).token;
        goto L6
    }
}
