package com.bytedance.ee.bear.document.oops;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OopsModel implements NonProguard {
    private List<Button> buttons;
    private String code;
    private String content;
    private boolean hideCode;
    private String title;

    public static class Button implements NonProguard {
        private int id;
        private String text;

        public Button() {
        }

        public int getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(int r1) {
            this.id = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }
    }

    public OopsModel() {
    }

    public List<Button> getButtons() {
        return this.buttons;
    }

    public String getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isHideCode() {
        return this.hideCode;
    }

    public void setButtons(List<Button> r1) {
        this.buttons = r1;
    }

    public void setCode(String r1) {
        this.code = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setHideCode(boolean r1) {
        this.hideCode = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
