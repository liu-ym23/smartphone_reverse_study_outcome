package com.bytedance.ee.bear.document.oops;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class OopsModel implements NonProguard {
    private List<Button> buttons;
    private String code;
    private String content;
    private boolean hideCode;
    private String title;

    public static class Button implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private int f220710id;
        private String text;

        public Button() {
        }

        public int getId() {
            return this.f220710id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(int r100) {
            this.f220710id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
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

    public void setButtons(List<Button> r100) {
        this.buttons = r100;
    }

    public void setCode(String r100) {
        this.code = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setHideCode(boolean r100) {
        this.hideCode = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
