package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class ImageCardsData implements NonProguard {
    private String cur_comment_id;
    private Map<String, CardCommentData> data;
    private boolean show_input;
    private boolean show_more;
    private boolean show_reaction;
    private boolean show_resolve;
    private boolean show_voice;

    public String toString() {
        return "ImageCardsData{cur_comment_id='" + this.cur_comment_id + "', show_input=" + this.show_input + ", show_voice=" + this.show_voice + ", show_more=" + this.show_more + ", show_resolve=" + this.show_resolve + ", show_reaction=" + this.show_reaction + ", data=" + this.data + '}';
    }

    public ImageCardsData() {
        this.show_voice = false;
        this.show_more = false;
        this.show_resolve = false;
    }

    public String getCur_comment_id() {
        return this.cur_comment_id;
    }

    public Map<String, CardCommentData> getData() {
        return this.data;
    }

    public boolean isShow_input() {
        return this.show_input;
    }

    public boolean isShow_more() {
        return this.show_more;
    }

    public boolean isShow_reaction() {
        return this.show_reaction;
    }

    public boolean isShow_resolve() {
        return this.show_resolve;
    }

    public boolean isShow_voice() {
        return this.show_voice;
    }

    public void setCur_comment_id(String r100) {
        this.cur_comment_id = r100;
    }

    public void setData(Map<String, CardCommentData> r100) {
        this.data = r100;
    }

    public void setShow_input(boolean r100) {
        this.show_input = r100;
    }

    public void setShow_more(boolean r100) {
        this.show_more = r100;
    }

    public void setShow_reaction(boolean r100) {
        this.show_reaction = r100;
    }

    public void setShow_resolve(boolean r100) {
        this.show_resolve = r100;
    }

    public void setShow_voice(boolean r100) {
        this.show_voice = r100;
    }
}
