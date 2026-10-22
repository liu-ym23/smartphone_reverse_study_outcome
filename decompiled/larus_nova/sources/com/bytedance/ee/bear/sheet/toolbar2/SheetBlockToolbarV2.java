package com.bytedance.ee.bear.sheet.toolbar2;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockToolbarV2 extends ToolbarV2 {
    private Data data;
    private String srcObjToken;
    private int srcObjType;
    private BearUrl url;

    public static class Data implements NonProguard {
        private Input input;

        public Data() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.input});
        }

        public String toString() {
            return "Data{input=" + this.input + '}';
        }

        public Input getInput() {
            return this.input;
        }

        public static /* synthetic */ Input access$000(Data r100) {
            return r100.input;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (getClass() == r100.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.input, ((Data) r100).input);
        }

        public void setInput(Input r100) {
            this.input = r100;
        }
    }

    public static class Input implements NonProguard {
        private String cellInfo;
        private int objType;
        private List<BaseSegment> segments;
        public SegmentStyle style;
        private String token;
        public String value;

        public String getToken() {
            String r100 = this.token;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        public int hashCode() {
            SegmentStyle r100 = this.style;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            if (getSegments() == null) goto L10;
            r101 = getSegments().hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Input{style=" + this.style + ", segments=" + this.segments + '}';
        }

        public Input() {
            this.cellInfo = "";
        }

        public String getCellInfo() {
            return this.cellInfo;
        }

        public int getObjType() {
            return this.objType;
        }

        public List<BaseSegment> getSegments() {
            return this.segments;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Input) == true) goto L8;
            return false;
        L8:
            Input r101 = (Input) r100;
            if (Objects.equals(this.style, r101.style) == true) goto L12;
            return false;
        L12:
            if (getSegments() == null) goto L15;
            return getSegments().equals(r101.getSegments());
        L15:
            if (r101.getSegments() == null) goto L20;
            return false;
        L20:
            return true;
        }

        public void setCellInfo(String r100) {
            this.cellInfo = r100;
        }

        public void setObjType(int r100) {
            this.objType = r100;
        }

        public void setSegments(List<BaseSegment> r100) {
            this.segments = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.data, this.url, this.srcObjToken, Integer.valueOf(this.srcObjType)});
    }

    public Input getInput() {
        Data r100 = this.data;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getInput();
    }

    public void parseSegments() {
        Data r100 = this.data;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Data.access$000(r100) == null) goto L9;
        Input r101 = Data.access$000(this.data);
        r101.setSegments(ym5.b.a(r101.value));
        return;
    }

    public SheetBlockToolbarV2() {
    }

    public Data getData() {
        return this.data;
    }

    public String getSrcObjToken() {
        return this.srcObjToken;
    }

    public int getSrcObjType() {
        return this.srcObjType;
    }

    public BearUrl getUrl() {
        return this.url;
    }

    public SheetBlockToolbarV2(ToolbarV2 r100) {
        setItems(r100.getItems());
        setShowingItemId(r100.getShowingItemId());
        setType(r100.getType());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        SheetBlockToolbarV2 r101 = (SheetBlockToolbarV2) r100;
        if (Objects.equals(this.data, r101.data) == true) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.url, r101.url) == false) goto L19;
        if (Objects.equals(this.srcObjToken, r101.srcObjToken) == false) goto L19;
        if (Objects.equals(Integer.valueOf(this.srcObjType), Integer.valueOf(r101.srcObjType)) == false) goto L19;
        return true;
    }

    public void setData(Data r100) {
        this.data = r100;
    }

    public void setInput(Input r100) {
        Data r101 = this.data;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getInput() == null) goto L9;
        this.data.setInput(r100);
        return;
    }

    public void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }

    public void setUrl(BearUrl r100) {
        this.url = r100;
        Data r101 = this.data;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getInput() == null) goto L9;
        this.data.getInput().setToken(r100.f222561b);
        return;
    }

    public void updateInputTokenAndType(String r100, int r101) {
        Data r102 = this.data;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getInput() != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.data.getInput().setToken(r100);
    L9:
        if (r101 <= 0) goto L14;
        this.data.getInput().setObjType(r101);
        return;
    }
}
