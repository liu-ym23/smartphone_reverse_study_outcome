package com.ss.android.lark.todo.impl.framework.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "todo_config")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/framework/config/TodoConfig;", "", "assigneeLimit", "", "followerLimit", "titleLimit", "descriptionLimit", "commentLimit", "<init>", "(IIIII)V", "getAssigneeLimit", "()I", "setAssigneeLimit", "(I)V", "getFollowerLimit", "setFollowerLimit", "getTitleLimit", "setTitleLimit", "getDescriptionLimit", "setDescriptionLimit", "getCommentLimit", "setCommentLimit", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoConfig {

    @SerializedName("assignee_limit")
    private int assigneeLimit;

    @SerializedName("comment_limit")
    private int commentLimit;

    @SerializedName("description_limit")
    private int descriptionLimit;

    @SerializedName("follower_limit")
    private int followerLimit;

    @SerializedName("title_limit")
    private int titleLimit;

    public TodoConfig() {
        this.assigneeLimit = 500;
        this.followerLimit = 500;
        this.titleLimit = Integer.MAX_VALUE;
        this.descriptionLimit = Integer.MAX_VALUE;
        this.commentLimit = Integer.MAX_VALUE;
    }

    public final int a() {
        return this.assigneeLimit;
    }

    public final int b() {
        return this.commentLimit;
    }

    public final int c() {
        return this.descriptionLimit;
    }

    public final int d() {
        return this.followerLimit;
    }

    public final int e() {
        return this.titleLimit;
    }
}
