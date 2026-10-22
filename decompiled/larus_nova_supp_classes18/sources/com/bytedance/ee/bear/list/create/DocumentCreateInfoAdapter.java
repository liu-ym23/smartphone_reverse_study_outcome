package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setObjToken(String r1) {
            this.obj_token = r1;
        }

        public void setObjType(int r1) {
            this.obj_type = r1;
        }

        public void setObjUrl(String r1) {
            this.obj_url = r1;
        }

        public void setOwnerType(int r1) {
            this.owner_type = r1;
        }

        public void setShareFolder(boolean r1) {
            this.is_share_folder = r1;
        }

        public void setSpaceId(String r1) {
            this.spaceId = r1;
        }

        public void setTemplateToken(String r1) {
            this.template_token = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }
    }

    public DocumentCreateInfoAdapter() {
    }

    public DocumentCreateEntity toDocumentCreateInfo(boolean r6) {
        DocumentCreateEntity r0 = new DocumentCreateEntity();
        ((Result) r0).code = ((Result) this).code;
        ((Result) r0).msg = ((Result) this).msg;
        Object r1 = ((Result) this).data;
        String r2 = "";
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        r0.token = r3;
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        r0.objToken = r4;
        if (r1 != null) goto L13;
        String r5 = "";
    L14:
        r0.templateToken = r5;
        if (r1 != null) goto L17;
        String r7 = "";
    L18:
        r0.title = r7;
        if (r1 != null) goto L21;
        String r8 = "";
    L22:
        r0.url = r8;
        boolean r9 = false;
        if (r1 != null) goto L25;
        int r10 = 0;
    L26:
        r0.ownerType = r10;
        if (r1 != null) goto L29;
        boolean r11 = false;
    L30:
        r0.isShareFolder = r11;
        if (r1 != null) goto L33;
        int r12 = 0;
    L36:
        r0.type = r12;
        if (r1 != null) goto L39;
        int r13 = 0;
    L40:
        r0.objType = r13;
        if (r1 != null) goto L44;
    L46:
        r0.isWiki = r9;
        if (r1 == null) goto L50;
        r2 = ((InnerData) r1).spaceId;
    L50:
        r0.spaceId = r2;
        return r0;
    L44:
        if (sbb.e.n.b != ((InnerData) r1).type) goto L46;
        r9 = true;
        goto L46
    L39:
        r13 = ((InnerData) r1).obj_type;
        goto L40
    L33:
        if (r6 == false) goto L35;
        r12 = ((InnerData) r1).obj_type;
        goto L36
    L35:
        r12 = ((InnerData) r1).type;
        goto L36
    L29:
        r11 = ((InnerData) r1).is_share_folder;
        goto L30
    L25:
        r10 = ((InnerData) r1).owner_type;
        goto L26
    L21:
        r8 = ((InnerData) r1).obj_url;
        goto L22
    L17:
        r7 = ((InnerData) r1).title;
        goto L18
    L13:
        r5 = ((InnerData) r1).template_token;
        goto L14
    L9:
        r4 = ((InnerData) r1).obj_token;
        goto L10
    L5:
        r3 = ((InnerData) r1).token;
        goto L6
    }
}
