package com.flow.cmark.adapter;

/* JADX INFO: loaded from: classes23.dex */
public class CMarkNodeJava {
    public String codeLanguage;
    public String codeLiteral;
    public String content;
    public CMarkNodeJava firstChild;
    public String formulaLiteral;
    public int headingLevel;
    public boolean isDone;
    public boolean isFormulaByRedundantSlash;
    public CMarkNodeJava lastChild;
    public int listItemIndex;
    public int listStartIndex;
    public int listType;
    public String literal;
    public CMarkNodeJava next;
    public CMarkNodeJava parent;
    public CMarkNodeJava prev;
    public char tableAlignment;
    public String title;
    public int type;
    public String typeString;
    public String url;

    public void setCodeLanguage(String r100) {
        this.codeLanguage = r100;
    }

    public void setCodeLiteral(String r100) {
        this.codeLiteral = r100;
    }

    public void setFirstChild(CMarkNodeJava r100) {
        this.firstChild = r100;
    }

    public void setFormulaLiteral(String r100) {
        this.formulaLiteral = r100;
    }

    public void setHeadingLevel(int r100) {
        this.headingLevel = r100;
    }

    public void setIsFormulaByRedundantSlash(boolean r100) {
        this.isFormulaByRedundantSlash = r100;
    }

    public void setLastChild(CMarkNodeJava r100) {
        this.lastChild = r100;
    }

    public void setListItemIndex(int r100) {
        this.listItemIndex = r100;
    }

    public void setListStartIndex(int r100) {
        this.listStartIndex = r100;
    }

    public void setListType(int r100) {
        this.listType = r100;
    }

    public void setNext(CMarkNodeJava r100) {
        this.next = r100;
    }

    public void setParent(CMarkNodeJava r100) {
        this.parent = r100;
    }

    public void setPrev(CMarkNodeJava r100) {
        this.prev = r100;
    }

    public void setTableAlignment(char r100) {
        this.tableAlignment = r100;
    }

    public void setTaskListIsDone(boolean r100) {
        this.isDone = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public CMarkNodeJava(String r100, String r101, int r102, String r103) {
        this.content = r100;
        this.literal = r101;
        this.type = r102;
        this.typeString = r103;
    }
}
