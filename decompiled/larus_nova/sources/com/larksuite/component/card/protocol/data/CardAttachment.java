package com.larksuite.component.card.protocol.data;

import com.larksuite.component.card.protocol.data.at.AtProperty;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.protocol.data.person.Character;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR:\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR>\u0010\u0015\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR:\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR:\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/larksuite/component/card/protocol/data/CardAttachment;", "Ljava/io/Serializable;", "<init>", "()V", "images", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/widget/richtext/RichTextElement$ImageProperty;", "Lkotlin/collections/HashMap;", "getImages", "()Ljava/util/HashMap;", "setImages", "(Ljava/util/HashMap;)V", "atUsers", "Lcom/larksuite/component/card/protocol/data/at/AtProperty;", "getAtUsers", "setAtUsers", "optionUsers", "Lcom/larksuite/component/card/protocol/data/options/OptionUser;", "getOptionUsers", "setOptionUsers", "characters", "Lcom/larksuite/component/card/protocol/data/person/Character;", "getCharacters", "setCharacters", "audios", "Lcom/larksuite/component/card/protocol/data/media/AudioInfo;", "getAudios", "setAudios", "videos", "Lcom/larksuite/component/card/protocol/data/media/VideoInfo;", "getVideos", "setVideos", "summary", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAttachment implements Serializable {
    public static final a Companion = null;
    private HashMap<String, AtProperty> atUsers;
    private HashMap<String, AudioInfo> audios;
    private HashMap<String, Character> characters;
    private HashMap<String, RichTextElement.ImageProperty> images;
    private HashMap<String, OptionUser> optionUsers;
    private String summary;
    private HashMap<String, VideoInfo> videos;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardAttachment() {
    }

    public final HashMap<String, AtProperty> getAtUsers() {
        return this.atUsers;
    }

    public final HashMap<String, AudioInfo> getAudios() {
        return this.audios;
    }

    public final HashMap<String, Character> getCharacters() {
        return this.characters;
    }

    public final HashMap<String, RichTextElement.ImageProperty> getImages() {
        return this.images;
    }

    public final HashMap<String, OptionUser> getOptionUsers() {
        return this.optionUsers;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final HashMap<String, VideoInfo> getVideos() {
        return this.videos;
    }

    public final void setAtUsers(HashMap<String, AtProperty> r100) {
        this.atUsers = r100;
    }

    public final void setAudios(HashMap<String, AudioInfo> r100) {
        this.audios = r100;
    }

    public final void setCharacters(HashMap<String, Character> r100) {
        this.characters = r100;
    }

    public final void setImages(HashMap<String, RichTextElement.ImageProperty> r100) {
        this.images = r100;
    }

    public final void setOptionUsers(HashMap<String, OptionUser> r100) {
        this.optionUsers = r100;
    }

    public final void setSummary(String r100) {
        this.summary = r100;
    }

    public final void setVideos(HashMap<String, VideoInfo> r100) {
        this.videos = r100;
    }
}
