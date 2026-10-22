package com.ss.android.lark.todo.impl.forward;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class TodoForwardData implements Serializable {
    private String todoGuid;
    private String todoSummary;

    public TodoForwardData() {
    }

    public String getTodoGuid() {
        return this.todoGuid;
    }

    public String getTodoSummary() {
        return this.todoSummary;
    }

    public void setTodoGuid(String r100) {
        this.todoGuid = r100;
    }

    public void setTodoSummary(String r100) {
        this.todoSummary = r100;
    }
}
