package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocumentListInfo extends Result {
    private boolean all_visited;
    private String checkId;
    private ArrayList<Document> documentList;
    private HashMap<String, Document> fakeTokenMap;
    private boolean hasMore;
    private boolean has_hidden;
    private String lastLabel;
    private String nextId;
    private Document parent;
    private ShareFolderUserPermission parentPermission;
    private int total;

    public String toString() {
        return "DocumentListInfo{documentList= " + this.documentList + ", fakeTokenMap= " + this.fakeTokenMap + ", hasMore= " + this.hasMore + ", total= " + this.total + ", checkId= " + this.checkId + ", nextId= " + this.nextId + ", all_visited= " + this.all_visited + ", has_hidden= " + this.has_hidden + "} " + super/*java.lang.Object*/.toString();
    }

    public DocumentListInfo() {
    }

    public String getCheckId() {
        return this.checkId;
    }

    public ArrayList<Document> getDocumentList() {
        return this.documentList;
    }

    public HashMap<String, Document> getFakeTokenMap() {
        return this.fakeTokenMap;
    }

    public String getLastLabel() {
        return this.lastLabel;
    }

    public String getNextId() {
        return this.nextId;
    }

    public Document getParent() {
        return this.parent;
    }

    public ShareFolderUserPermission getParentPermission() {
        return this.parentPermission;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isAll_visited() {
        return this.all_visited;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public boolean isHas_hidden() {
        return this.has_hidden;
    }

    public void setAll_visited(boolean r1) {
        this.all_visited = r1;
    }

    public void setCheckId(String r1) {
        this.checkId = r1;
    }

    public void setDocumentList(ArrayList<Document> r1) {
        this.documentList = r1;
    }

    public void setFakeTokenMap(HashMap<String, Document> r1) {
        this.fakeTokenMap = r1;
    }

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setHas_hidden(boolean r1) {
        this.has_hidden = r1;
    }

    public void setLastLabel(String r1) {
        this.lastLabel = r1;
    }

    public void setNextId(String r1) {
        this.nextId = r1;
    }

    public void setParent(Document r1) {
        this.parent = r1;
    }

    public void setParentPermission(ShareFolderUserPermission r1) {
        this.parentPermission = r1;
    }

    public void setTotal(int r1) {
        this.total = r1;
    }
}
