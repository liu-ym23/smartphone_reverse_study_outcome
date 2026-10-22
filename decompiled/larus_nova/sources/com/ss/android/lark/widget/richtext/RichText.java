package com.ss.android.lark.widget.richtext;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class RichText implements Serializable {
    private List<String> anchorIds;
    private List<String> atIds;
    private ArrayList<String> atUserGroupIds;
    private List<String> docsIds;
    private List<String> elementIds;
    private RichTextElements elements;
    private RichTextExtraInfo extraInfo;
    private boolean hasParsed;
    private List<String> imageIds;
    private String innerText;
    private ArrayList<String> markdownIds;
    private List<String> mediaIds;
    private ArrayList<String> myAIRunningToolsIds;
    private int richTextVersion;

    @JSONField(serialize = false)
    private List<String> urls;

    public static class RichTextElements implements Serializable {
        private Map<String, RichTextElement> dictionary;

        public int hashCode() {
            return Objects.hash(new Object[]{this.dictionary});
        }

        public RichTextElements() {
            this.dictionary = new HashMap();
        }

        public Map<String, RichTextElement> getDictionary() {
            return this.dictionary;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if ((r100 instanceof RichTextElements) == false) goto L17;
            Map<String, RichTextElement> r101 = this.dictionary;
            Map<String, RichTextElement> r102 = ((RichTextElements) r100).dictionary;
            if (r101 != null) goto L18;
            if (r102 == null) goto L19;
            return false;
        L19:
            return true;
        L18:
            return r101.equals(r102);
        }

        public void setDictionary(Map<String, RichTextElement> r100) {
            this.dictionary = new HashMap(r100);
        }
    }

    public RichText() {
        this(null);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.elementIds, this.elements});
    }

    public List<String> getAnchorIds() {
        return this.anchorIds;
    }

    public List<String> getAtIds() {
        return this.atIds;
    }

    public ArrayList<String> getAtUserGroupIds() {
        return this.atUserGroupIds;
    }

    public List<String> getDocsIds() {
        return this.docsIds;
    }

    public List<String> getElementIds() {
        return this.elementIds;
    }

    public RichTextElements getElements() {
        return this.elements;
    }

    public RichTextExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public List<String> getImageIds() {
        return this.imageIds;
    }

    public String getInnerText() {
        return this.innerText;
    }

    public List<String> getMarkdownIds() {
        return this.markdownIds;
    }

    public List<String> getMediaIds() {
        return this.mediaIds;
    }

    public ArrayList<String> getMyAIRunningToolsIds() {
        return this.myAIRunningToolsIds;
    }

    public int getRichTextVersion() {
        return this.richTextVersion;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public boolean hasParsed() {
        return this.hasParsed;
    }

    public RichText(RichText r100) {
        int r101 = 0;
        this.richTextVersion = 0;
        if (r100 != null) goto L5;
        RichTextElements r102 = new RichTextElements();
    L6:
        this.elements = r102;
        if (r100 != null) goto L9;
        ArrayList r103 = new ArrayList();
    L10:
        this.elementIds = r103;
        if (r100 != null) goto L13;
        List<String> r104 = new ArrayList();
    L14:
        this.anchorIds = r104;
        if (r100 != null) goto L17;
        List<String> r105 = new ArrayList();
    L18:
        this.atIds = r105;
        if (r100 != null) goto L21;
        List<String> r106 = new ArrayList();
    L22:
        this.imageIds = r106;
        if (r100 != null) goto L25;
        List<String> r107 = new ArrayList();
    L26:
        this.mediaIds = r107;
        if (r100 != null) goto L29;
        String r108 = "";
    L30:
        this.innerText = r108;
        if (r100 != null) goto L33;
        List<String> r109 = new ArrayList();
    L34:
        this.docsIds = r109;
        if (r100 != null) goto L37;
    L40:
        ArrayList<String> r110 = new ArrayList();
    L41:
        this.markdownIds = r110;
        if (r100 != null) goto L44;
        ArrayList<String> r111 = new ArrayList();
    L45:
        this.myAIRunningToolsIds = r111;
        if (r100 != null) goto L48;
        ArrayList<String> r112 = new ArrayList();
    L49:
        this.atUserGroupIds = r112;
        if (r100 == null) goto L53;
        r101 = r100.richTextVersion;
    L53:
        this.richTextVersion = r101;
        if (r100 != null) goto L56;
        RichTextExtraInfo r113 = new RichTextExtraInfo();
    L57:
        this.extraInfo = r113;
        return;
    L56:
        r113 = r100.getExtraInfo();
        goto L57
    L48:
        r112 = r100.getAtUserGroupIds();
        goto L49
    L44:
        r111 = r100.getMyAIRunningToolsIds();
        goto L45
    L37:
        if (r100.getMarkdownIds() == null) goto L40;
        r110 = new ArrayList(r100.getMarkdownIds());
        goto L41
    L33:
        r109 = r100.getDocsIds();
        goto L34
    L29:
        r108 = r100.getInnerText();
        goto L30
    L25:
        r107 = r100.getMediaIds();
        goto L26
    L21:
        r106 = r100.getImageIds();
        goto L22
    L17:
        r105 = r100.getAtIds();
        goto L18
    L13:
        r104 = r100.getAnchorIds();
        goto L14
    L9:
        r103 = new ArrayList(r100.getElementIds());
        goto L10
    L5:
        r102 = r100.getElements();
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        RichText r101 = (RichText) r100;
        List<String> r102 = this.elementIds;
        if (r102 == null) goto L16;
        if (r102.equals(r101.elementIds) == false) goto L17;
    L18:
        RichTextElements r103 = this.elements;
        RichTextElements r104 = r101.elements;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.elementIds == null) goto L18;
        goto L17
    }

    public void setAnchorIds(List<String> r100) {
        this.anchorIds = new ArrayList(r100);
    }

    public void setAtIds(List<String> r100) {
        this.atIds = new ArrayList(r100);
    }

    public void setAtUserGroupIds(List<String> r100) {
        this.atUserGroupIds = new ArrayList(r100);
    }

    public void setDocsIds(List<String> r100) {
        this.docsIds = new ArrayList(r100);
    }

    public void setElementIds(List<String> r100) {
        this.elementIds = new ArrayList(r100);
    }

    public void setElements(RichTextElements r100) {
        this.elements = r100;
    }

    public void setExtraInfo(RichTextExtraInfo r100) {
        this.extraInfo = r100;
    }

    public void setHasParsed(boolean r100) {
        this.hasParsed = r100;
    }

    public void setImageIds(List<String> r100) {
        this.imageIds = new ArrayList(r100);
    }

    public void setInnerText(String r100) {
        this.innerText = r100;
    }

    public void setMarkdownIds(List<String> r100) {
        if (r100 != null) goto L5;
        this.markdownIds = new ArrayList();
        return;
    L5:
        this.markdownIds = new ArrayList(r100);
    }

    public void setMediaIds(List<String> r100) {
        this.mediaIds = r100;
    }

    public void setMyAIRunningToolsIds(ArrayList<String> r100) {
        this.myAIRunningToolsIds = r100;
    }

    public void setRichTextVersion(int r100) {
        this.richTextVersion = r100;
    }

    public void setUrls(List<String> r100) {
        this.urls = r100;
    }
}
