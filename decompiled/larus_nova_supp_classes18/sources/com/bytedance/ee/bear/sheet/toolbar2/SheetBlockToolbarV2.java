package com.bytedance.ee.bear.sheet.toolbar2;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public static /* synthetic */ Input access$000(Data r0) {
            return r0.input;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (getClass() == r3.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.input, ((Data) r3).input);
        }

        public void setInput(Input r1) {
            this.input = r1;
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
            String r0 = this.token;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public int hashCode() {
            SegmentStyle r0 = this.style;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            if (getSegments() == null) goto L10;
            r1 = getSegments().hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Input) == true) goto L8;
            return false;
        L8:
            Input r6 = (Input) r5;
            if (Objects.equals(this.style, r6.style) == true) goto L12;
            return false;
        L12:
            if (getSegments() == null) goto L15;
            return getSegments().equals(r6.getSegments());
        L15:
            if (r6.getSegments() == null) goto L20;
            return false;
        L20:
            return true;
        }

        public void setCellInfo(String r1) {
            this.cellInfo = r1;
        }

        public void setObjType(int r1) {
            this.objType = r1;
        }

        public void setSegments(List<BaseSegment> r1) {
            this.segments = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.data, this.url, this.srcObjToken, Integer.valueOf(this.srcObjType)});
    }

    public Input getInput() {
        Data r0 = this.data;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInput();
    }

    public void parseSegments() {
        Data r0 = this.data;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Data.access$000(r0) == null) goto L9;
        Input r1 = Data.access$000(this.data);
        r1.setSegments(ym5.b.a(r1.value));
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

    public SheetBlockToolbarV2(ToolbarV2 r2) {
        setItems(r2.getItems());
        setShowingItemId(r2.getShowingItemId());
        setType(r2.getType());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        SheetBlockToolbarV2 r6 = (SheetBlockToolbarV2) r5;
        if (Objects.equals(this.data, r6.data) == true) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.url, r6.url) == false) goto L19;
        if (Objects.equals(this.srcObjToken, r6.srcObjToken) == false) goto L19;
        if (Objects.equals(Integer.valueOf(this.srcObjType), Integer.valueOf(r6.srcObjType)) == false) goto L19;
        return true;
    }

    public void setData(Data r1) {
        this.data = r1;
    }

    public void setInput(Input r2) {
        Data r0 = this.data;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getInput() == null) goto L9;
        this.data.setInput(r2);
        return;
    }

    public void setSrcObjToken(String r1) {
        this.srcObjToken = r1;
    }

    public void setSrcObjType(int r1) {
        this.srcObjType = r1;
    }

    public void setUrl(BearUrl r2) {
        this.url = r2;
        Data r0 = this.data;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getInput() == null) goto L9;
        this.data.getInput().setToken(r2.b);
        return;
    }

    public void updateInputTokenAndType(String r2, int r3) {
        Data r0 = this.data;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getInput() != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        this.data.getInput().setToken(r2);
    L9:
        if (r3 <= 0) goto L14;
        this.data.getInput().setObjType(r3);
        return;
    }
}
